package com.example.messageapplication.Server;

import com.example.messageapplication.Models.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    public static ArrayList<ClientHandler> clientHandlers=new ArrayList<>();
    private Socket socket;
    private ObjectInputStream bufferedReader;
    private ObjectOutputStream bufferedWriter;
    private String ClientUserName;
    public ClientHandler(Socket socket){
        try{
            this.socket=socket;
            this.bufferedWriter=new ObjectOutputStream((socket.getOutputStream()));
            this.bufferedReader=new ObjectInputStream((socket.getInputStream()));
            this.ClientUserName = (String) bufferedReader.readObject();
            clientHandlers.add(this);
            brodcastMessage(new Message("","","","Server : "+ClientUserName+"Joined"));
        }catch (IOException e){
            closeEverything(socket,bufferedReader,bufferedWriter);} catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        Message messageFromClient;
        while(socket.isConnected()){
            try{
                messageFromClient=(Message)bufferedReader.readObject();
                brodcastMessage(messageFromClient);
            }catch (IOException e){
                closeEverything(socket,bufferedReader,bufferedWriter);
                break;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void brodcastMessage(Message messageToSend){
        for(ClientHandler clientHandler:clientHandlers){
            try{
                if(clientHandler.ClientUserName.equals(messageToSend.Reciever)){
                    clientHandler.bufferedWriter.writeObject(messageToSend);
                    clientHandler.bufferedWriter.flush();}

            }catch (IOException e){
                closeEverything(socket,bufferedReader,bufferedWriter);
            }
        }
    }
    public void removeClientHandler(){
        clientHandlers.remove(this);
        brodcastMessage(new Message("","","","Server : "+this.ClientUserName+"Has left the chat"));
    }
    public void closeEverything(Socket socket,ObjectInputStream bufferedReader ,ObjectOutputStream bufferedWriter){
        removeClientHandler();
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket!=null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
