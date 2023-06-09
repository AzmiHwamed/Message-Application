package com.example.messageapplication.UI;


import com.example.messageapplication.Controllers.AllUsersController;
import com.example.messageapplication.Controllers.FriendReqController;
import com.example.messageapplication.Controllers.MessagingController;
import com.example.messageapplication.Navigator.Navigator;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.SQLException;

public class BottomNavigation extends HBox {
    public ImageView imageView1;
    public ImageView imageView2;
    public ImageView imageView3;
    public Region sp1 ;
    public Region sp2 ;
    public BottomNavigation() {
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), Insets.EMPTY)));

        Image image1 = new Image("comments.png");
        Image image2 = new Image("friend-request.png");
        Image image3 = new Image("users.png");

        image1 = new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\comments.png");
       image2 = new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\friend-request.png");
        image3 = new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\users.png");

        imageView1 = new ImageView(image1);
        imageView2 = new ImageView(image2);
        imageView3 = new ImageView(image3);
        imageView1.setFitWidth(30);
        imageView1.setFitHeight(30);
        imageView2.setFitWidth(40);
        imageView2.setFitHeight(40);
        imageView3.setFitWidth(40);
        imageView3.setFitHeight(40);

        sp1 = new Region();
        this.setHgrow(sp1, Priority.ALWAYS);

        sp2 = new Region();
        this.setHgrow(sp2, Priority.ALWAYS);

        this.getChildren().addAll(imageView1,sp1, imageView2,sp2, imageView3);

        imageView1.setCursor(Cursor.HAND);
        imageView2.setCursor(Cursor.HAND);
        imageView3.setCursor(Cursor.HAND);
        imageView1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                try {
                    MessagingParent.obj.call();
                    Navigator.getInstance().showScene("messaging");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        imageView2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FriendReqController.onCreate();
                    Navigator.getInstance().showScene("fr");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


            }
        });
        imageView3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    AllUsersController.onCreate();
                    Navigator.getInstance().showScene("users");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        //this.getChildren().addAll(imageView1, imageView2, imageView3);

        this.setHeight(100);
        this.setWidth(1000);
        this.setPadding(new Insets(10,90,10,90));
    }
}