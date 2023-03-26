package com.example.messageapplication.Server;

import com.example.messageapplication.Models.CurrentChatBuddy;
import com.example.messageapplication.Models.Message;
import com.example.messageapplication.UI.IncomingMessage;
import com.example.messageapplication.UI.MessagingParent;
import com.example.messageapplication.UI.MyMessage;
import javafx.application.Platform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static Client obj;
    private Socket socket;
    private MessagingParent mp;
    private ObjectInputStream bufferedReader;
    private ObjectOutputStream bufferedWriter;
    private String username="";
    public static Client getInstance(String i,MessagingParent mp) throws IOException {
        if(obj==null){
            obj=new Client(new Socket("localhost",1234),i, mp);
        }
        return obj;
    }

    public Client(Socket socket, String username,MessagingParent mp) {
        try{
            this.socket = socket;
            this.mp=mp;
            this.bufferedReader=new ObjectInputStream(socket.getInputStream());
            this.bufferedWriter=new ObjectOutputStream(socket.getOutputStream());
            this.username = username;
            bufferedWriter.writeObject(username);
            bufferedWriter.flush();
        }catch(IOException e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }
    public void sendMessage(String Username,String messageToSend){
        try{
                bufferedWriter.writeObject(new Message(username,Integer.toString(CurrentChatBuddy.GetCurrentUser().getId()),new SimpleDateFormat("dd/MM/yyyy").format(new Date()),messageToSend));
                bufferedWriter.flush();
                Message finalMsgFromGroupCHat = new Message(username,Username,new SimpleDateFormat("dd/MM/yyyy").format(new Date()),messageToSend);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        mp.MessagingMain.getChildren().add(new MyMessage(finalMsgFromGroupCHat.message));
                        mp.x.setVvalue(1.0);
                    }
                });


        }catch(IOException e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }
    public void ListenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msgFromGroupCHat;
                while(socket.isConnected()){
                    try{
                        msgFromGroupCHat = (Message)bufferedReader.readObject();
                        System.out.println(msgFromGroupCHat.Sender+":"+msgFromGroupCHat.message);
                        Message finalMsgFromGroupCHat = msgFromGroupCHat;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                mp.MessagingMain.getChildren().add(new IncomingMessage(finalMsgFromGroupCHat.message));
                                mp.x.setVvalue(1.0);
                            }
                        });
                        if(msgFromGroupCHat==null)
                            closeEverything(socket,bufferedReader,bufferedWriter);

                    }catch(IOException e){
                        closeEverything(socket,bufferedReader,bufferedWriter);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
    public void closeEverything(Socket socket,ObjectInputStream bufferedReader,ObjectOutputStream bufferedWriter){
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

    public static void main(String[] args) throws IOException {

    }
}
