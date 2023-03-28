package com.example.messageapplication.UI;

import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.SQLException;

public class MessagingScene extends Scene {
    public MessagingScene() throws IOException, SQLException {
        super(new MessagingParent());
    }
}
