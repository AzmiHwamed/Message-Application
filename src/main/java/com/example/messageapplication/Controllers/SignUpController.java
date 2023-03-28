package com.example.messageapplication.Controllers;

import com.example.messageapplication.DAO.DAO;
import com.example.messageapplication.Models.User;
import com.example.messageapplication.Navigator.Navigator;
import com.example.messageapplication.UI.SignUpParent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpController implements EventHandler<ActionEvent> {
    SignUpParent obj;

    public SignUpController(SignUpParent obj) {
        this.obj = obj;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            DAO.getInstance().Register(new User(0,obj.email.getText(),obj.password.getText(),obj.username.getText(),(String) obj.language.getSelectionModel().getSelectedItem(),(int)(obj.toggleGroup.getSelectedToggle().getUserData())+1));
            DAO.getInstance().Authentificate(obj.email.getText(),obj.password.getText());
            Navigator.getInstance().showScene("messaging");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
