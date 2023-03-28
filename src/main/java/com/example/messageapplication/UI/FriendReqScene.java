package com.example.messageapplication.UI;

import javafx.scene.Parent;
import javafx.scene.Scene;

import java.sql.SQLException;

public class FriendReqScene extends Scene {
    public FriendReqScene() throws SQLException {
        super(new FriendReqParent());
    }
}
