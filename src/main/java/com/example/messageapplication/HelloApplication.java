package com.example.messageapplication;

import com.example.messageapplication.Navigator.Navigator;
import com.example.messageapplication.UI.FriendReqScene;
import com.example.messageapplication.UI.SignInScene;
import com.example.messageapplication.UI.SignUpScene;
import com.example.messageapplication.UI.UsersParentScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Navigator.getInstance().setStage(stage);
        Navigator.getInstance().addScene("scene",new FriendReqScene());
        Navigator.getInstance().showScene("scene");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}