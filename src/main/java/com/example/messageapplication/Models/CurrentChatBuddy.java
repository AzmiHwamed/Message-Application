package com.example.messageapplication.Models;

public class CurrentChatBuddy {
    static User curr;
    public static User GetCurrentUser(){
        return curr;
    }
    public static void SetUser(User user){
        curr=user;
    }
}
