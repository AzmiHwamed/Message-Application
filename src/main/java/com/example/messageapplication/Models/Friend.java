package com.example.messageapplication.Models;

public class Friend {
    int User1;
    int User2;

    public void setUser1(int user1) {
        User1 = user1;
    }

    public void setUser2(int user2) {
        User2 = user2;
    }

    public int getUser1() {
        return User1;
    }

    public int getUser2() {
        return User2;
    }

    public Friend(int user1, int user2) {
        User1 = user1;
        User2 = user2;
    }
}
