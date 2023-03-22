package com.example.messageapplication.Models;

public class FriendRequest {
    int Sender;
    int Reciever;

    public void setSender(int sender) {
        Sender = sender;
    }

    public void setReciever(int reciever) {
        Reciever = reciever;
    }

    public int getSender() {
        return Sender;
    }

    public int getReciever() {
        return Reciever;
    }

    public FriendRequest(int sender, int reciever) {
        Sender = sender;
        Reciever = reciever;
    }
}
