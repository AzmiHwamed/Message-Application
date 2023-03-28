package com.example.messageapplication.Models;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    public String Reciever;
    public String Sender;
    public String date;
    public String message;

    public Message(String UserName,String targetUserName, String date,String message) {
        Reciever = targetUserName;
        this.date=date;
        this.Sender=UserName;
        this.message = message;
    }
}
