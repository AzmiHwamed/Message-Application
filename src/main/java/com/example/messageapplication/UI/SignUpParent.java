package com.example.messageapplication.UI;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.FileNotFoundException;




public class SignUpParent extends BorderPane {
    public TextField email;
    public TextField password;
    public TextField username;
    public ComboBox language;
    public HBox avatar;

    public VBox vsign_up;
    public Button signup;
    public Image im_logo;
    public ImageView logo;
    public Label sign_up;
    public Text t1;
    public Text t2;
    public Text t3;
    public TextFlow txt;
    public VBox btn_box;
    public Text choose_avatar;

    String[] imagePaths = {
            "C:\\Users\\ASUS\\Documents\\Message-Application\\src\\main\\resources\\1.png",
            "C:\\Users\\ASUS\\Documents\\Message-Application\\src\\main\\resources\\2.png",
            "C:\\Users\\ASUS\\Documents\\Message-Application\\src\\main\\resources\\3.png",
            "C:\\Users\\ASUS\\Documents\\Message-Application\\src\\main\\resources\\4.png",
            "C:\\Users\\ASUS\\Documents\\Message-Application\\src\\main\\resources\\5.png",
            "C:\\Users\\ASUS\\Documents\\Message-Application\\src\\main\\resources\\6.png",
            "C:\\Users\\ASUS\\Documents\\Message-Application\\src\\main\\resources\\7.png",
            "C:\\Users\\ASUS\\Documents\\Message-Application\\src\\main\\resources\\8.png",
            "C:\\Users\\ASUS\\Documents\\Message-Application\\src\\main\\resources\\9.png",

    };
    ToggleGroup toggleGroup;
    public SignUpParent() {
        email=new TextField();
        email.setPromptText("E_mail");
        email.setPrefHeight(40);
        password=new TextField();
        password.setPrefHeight(40);
        password.setPromptText("password");
        username=new TextField();
        username.setPromptText("UserName");
        username.setPrefHeight(40);
        language=new ComboBox();
        language.getItems().addAll("FR","ANG","ESP");
        language.setPromptText("Select your native language");
        language.setPrefHeight(40);
        avatar=new HBox();
        avatar.setSpacing(30);
        toggleGroup=new ToggleGroup();
        for (int i = 0; i < imagePaths.length; i++) {
            Image image = new Image(imagePaths[i]);
            RadioButton radioButton = new RadioButton();
            radioButton.setUserData(i);
            radioButton.setToggleGroup(toggleGroup);
            ImageView imv =new ImageView(image);
            imv.setFitHeight(80);
            imv.setFitWidth(80);

            radioButton.setGraphic(imv);
            radioButton.setGraphicTextGap(5);
            avatar.getChildren().add(radioButton);
        }

        vsign_up=new VBox();
        vsign_up.setPadding(new Insets(40,100,40,100));
        vsign_up.setSpacing(20);
        vsign_up.setAlignment(Pos.TOP_CENTER);
        language.prefWidthProperty().bind(this.vsign_up.widthProperty());
        signup=new Button("Sign Up");
        signup.setPrefSize(1028,30);
        signup.setStyle("-fx-background-color: #6087EB; -fx-text-fill: white;");
        signup.prefWidthProperty().bind(vsign_up.widthProperty());
        im_logo=new Image("plogo.png");
        logo=new ImageView(im_logo);
        logo.setFitHeight(100);
        logo.setFitWidth(300);
        t1=new Text("Already have an account? ");
        t2=new Text("Sign in ");
        t2.setFill(Color.web("#6087EB"));
        t3=new Text("now ");
        txt=new TextFlow(t1,t2,t3);
        choose_avatar=new Text("Choose your Avatar : ");
        vsign_up.setMargin(choose_avatar,new Insets(20, 1000, 10, 0));
        sign_up=new Label();
        sign_up.setGraphic(txt);
        btn_box=new VBox();
        btn_box.setSpacing(30);
        btn_box.getChildren().addAll(signup,sign_up);
        btn_box.setAlignment(Pos.CENTER);
        vsign_up.getChildren().addAll(logo,email,username,password,language,choose_avatar,avatar,btn_box);

        this.setCenter(vsign_up);
        //this.setBottom(new BottomNavigation());

    }

}

