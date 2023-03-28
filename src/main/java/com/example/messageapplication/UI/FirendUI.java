package com.example.messageapplication.UI;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

public class FirendUI extends HBox {
    public FirendUI(String msg,int avatar) {
        Label Msg=new Label(msg);
        this.setStyle("-fx-padding: 10;" + "-fx-border-width: 1;" + "-fx-border-radius: 5;" + "-fx-background-color: white;"+"-fx-border-color: #0CC0DF;");
        Msg.setBackground(Background.fill(Paint.valueOf("#FFFFFF")));
        Msg.setPrefWidth(1000);
        Msg.setAlignment(Pos.BASELINE_LEFT);
        Msg.setPrefHeight(60);
        this.setPrefHeight(60);
        this.setPrefWidth(500);
        ImageView img=new ImageView(new Image(avatar+".png"));
        img.setFitHeight(30);
        img.setFitWidth(30);
        this.getChildren().addAll(img,Msg);
        this.setSpacing(7);
        //this.setBackground(Background.fill(Paint.valueOf("#6087EB")));
        this.setBackground(Background.fill(Paint.valueOf("#f4f4f4")));
        this.setAlignment(Pos.CENTER_LEFT);
    }
}
