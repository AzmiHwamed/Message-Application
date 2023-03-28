package com.example.messageapplication;

import com.example.messageapplication.Navigator.Navigator;
import com.example.messageapplication.UI.FriendReqScene;
import com.example.messageapplication.UI.MessagingScene;
import com.example.messageapplication.UI.SignInScene;
import com.example.messageapplication.UI.SignUpScene;
import com.example.messageapplication.UI.UsersParentScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        stage.setResizable(false);
        Navigator.getInstance().setStage(stage);
        Navigator.getInstance().addScene("scene",new FriendReqScene());
        Navigator.getInstance().showScene("scene");

        Navigator.getInstance().addScene("signin",new SignInScene());
        Navigator.getInstance().addScene("messaging",new MessagingScene());
        Navigator.getInstance().showScene("signin");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}