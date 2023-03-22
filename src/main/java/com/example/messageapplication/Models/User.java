package com.example.messageapplication.Models;

public class User {
    int Id;
    String Email;
    String Password;
    String UserName;
    String Lang;
    int Avatar;

    public void setId(int id) {
        Id = id;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setLang(String lang) {
        Lang = lang;
    }

    public void setAvatar(int avatar) {
        Avatar = avatar;
    }

    public int getId() {
        return Id;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getLang() {
        return Lang;
    }

    public int getAvatar() {
        return Avatar;
    }

    public User(int id, String email, String password, String userName, String lang, int avatar) {
        Id = id;
        Email = email;
        Password = password;
        UserName = userName;
        Lang = lang;
        Avatar = avatar;
    }
}
