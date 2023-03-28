package com.example.messageapplication.UI;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class MyMessage extends HBox {
    public MyMessage(String msg) {
        Label Msg=new Label(msg);
        this.setStyle("-fx-padding: 10;" + "-fx-border-width: 1;" + "-fx-border-radius: 5;" + "-fx-background-color: white;"+"-fx-border-color: #6087EB;");
        Msg.setBackground(Background.fill(Paint.valueOf("#FFFFFF")));
        Msg.setPrefWidth(1000);
        Msg.setAlignment(Pos.CENTER_RIGHT);
        Msg.setPrefHeight(60);
        this.setPrefHeight(60);
        this.setPrefWidth(500);
        this.getChildren().add(Msg);
        //this.setBackground(Background.fill(Paint.valueOf("#6087EB")));
        this.setAlignment(Pos.CENTER_RIGHT);
    }
}
