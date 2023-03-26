package com.example.messageapplication.UI;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BottomNavigation extends HBox {
    public ImageView imageView1;
    public ImageView imageView2;
    public ImageView imageView3;
    public BottomNavigation() {


        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);
        this.setSpacing(300);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), Insets.EMPTY)));
        Image image1 = new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\comments (1).png");
        Image image2 = new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\friend-request.png");
        Image image3 = new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\users.png");
        imageView1 = new ImageView(image1);
        imageView2 = new ImageView(image2);
        imageView3 = new ImageView(image3);
        imageView1.setFitWidth(30);
        imageView1.setFitHeight(30);
        imageView2.setFitWidth(40);
        imageView2.setFitHeight(40);
        imageView3.setFitWidth(40);
        imageView3.setFitHeight(40);
        imageView1.setCursor(Cursor.HAND);
        imageView2.setCursor(Cursor.HAND);
        imageView3.setCursor(Cursor.HAND);

        this.getChildren().addAll(imageView1, imageView2, imageView3);
        this.setHeight(100);
        this.setWidth(1000);
    }
}