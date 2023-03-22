package com.example.messageapplication.Models;

public class CurrentUser {
    static User curr;
    public static User GetCurrentUser(){
        return curr;
    }
    public static void SetUser(User user){
        curr=user;
    }
}
