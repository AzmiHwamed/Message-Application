package com.example.messageapplication.UI;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class IncomingMessage extends HBox {
    public IncomingMessage(String msg) {
        Label Msg=new Label(msg);
        this.setStyle("-fx-padding: 0;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 10;" + "-fx-border-color: black;");
        Msg.setBackground(Background.fill(Paint.valueOf("#FFFFFF")));
        Msg.setPrefWidth(1000);
        Msg.setAlignment(Pos.BASELINE_LEFT);
        Msg.setPrefHeight(60);
        this.setPrefHeight(60);
        this.setPrefWidth(500);
        this.getChildren().add(Msg);
        //this.setBackground(Background.fill(Paint.valueOf("#6087EB")));
        this.setBackground(Background.fill(Paint.valueOf("#f4f4f4")));
        this.setAlignment(Pos.CENTER_LEFT);
    }
}
