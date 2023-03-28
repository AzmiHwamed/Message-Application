package com.example.messageapplication.UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class AppUser extends HBox {
    Image av_user;
    ImageView av_im;
   public Text username;
   public Image add;
   public ImageView im_add;
    Region spacer;

   public AppUser()
   {   av_user=new Image("1.png");
       av_im=new ImageView(av_user);
       av_im.setFitHeight(60);
       av_im.setFitWidth(60);
       username=new Text("aaaaa");
       add=new Image("add_user.png");
       im_add=new ImageView(add);
        im_add.setFitWidth(20);
        im_add.setFitHeight(20);
       this.setHgrow(username, Priority.ALWAYS);
       spacer = new Region();
       this.setHgrow(spacer, Priority.ALWAYS);
       this.setStyle("-fx-padding: 10;"
           + "-fx-border-width: 1;"
           + "-fx-border-radius: 5;" + "-fx-background-color: white;"+"-fx-border-color: #0CC0DF;");
       this.getChildren().addAll(av_im,username,spacer,im_add);
       this.setPrefHeight(60);
       this.setWidth(1000);
       this.setAlignment(Pos.CENTER);
       this.setSpacing(20);

   }

}
