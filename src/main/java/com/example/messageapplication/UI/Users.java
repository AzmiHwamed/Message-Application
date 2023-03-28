package com.example.messageapplication.UI;

import com.example.messageapplication.Models.User;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Users extends HBox {
Label uname;

    public Users(User u) {
        uname=new Label(u.getUserName());
        this.getChildren().addAll(uname);
        this.setHeight(100);
        this.setWidth(1000);


    }
}
