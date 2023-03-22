package com.example.messageapplication.Models;

import java.util.Date;

public class Message {
    int Sender;
    int Reciever;
    Date date;
    String Content;

    public void setSender(int sender) {
        Sender = sender;
    }

    public void setReciever(int reciever) {
        Reciever = reciever;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getSender() {
        return Sender;
    }

    public int getReciever() {
        return Reciever;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return Content;
    }

    public Message(int sender, int reciever, Date date, String content) {
        Sender = sender;
        Reciever = reciever;
        this.date = date;
        Content = content;
    }
}
