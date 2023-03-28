package com.example.messageapplication.Controllers;

import com.example.messageapplication.DAO.DAO;
import com.example.messageapplication.Models.User;
import com.example.messageapplication.Navigator.Navigator;
import com.example.messageapplication.UI.SignInParent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SignInController implements EventHandler<ActionEvent> {
    SignInParent obj;

    public SignInController(SignInParent obj) {
        this.obj = obj;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource()==obj.signin){
            try {
                if(DAO.getInstance().Authentificate(obj.email.getText(),obj.password.getText())){
                    Navigator.getInstance().showScene("messaging");
                }
                else{
                    System.out.println("wrong creds");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}