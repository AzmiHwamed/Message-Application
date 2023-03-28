package com.example.messageapplication.UI;

import javafx.scene.Scene;

import java.sql.SQLException;

public class UsersParentScene extends Scene {
    public UsersParentScene() throws SQLException {
        super(new UsersParent());
    }
}
