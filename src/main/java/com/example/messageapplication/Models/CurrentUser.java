package com.example.messageapplication.Models;

public class CurrentUser {
    static User curr=new User(0,"","","","",1);
    public static User GetCurrentUser(){
        return curr;
    }
    public static void SetUser(User user){
        curr=user;
    }
}
