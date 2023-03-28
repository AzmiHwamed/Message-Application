package com.example.messageapplication.Controllers;

import com.example.messageapplication.DAO.DAO;
import com.example.messageapplication.Models.CurrentUser;
import com.example.messageapplication.Models.User;
import com.example.messageapplication.UI.FriendReq;
import com.example.messageapplication.UI.FriendReqParent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

public class FriendReqController {
    static FriendReqParent obj;

    public FriendReqController(FriendReqParent obj) {
        this.obj = obj;
    }

    public static void onCreate() throws SQLException {
        obj.users.getChildren().clear();
        ArrayList<User> fr= DAO.getInstance().getFriendReqs();
        System.out.println(CurrentUser.GetCurrentUser().getId());
        System.out.println(fr);
        for(User user:fr){
            FriendReq f=new FriendReq();
            f.av_im.setImage(new Image(user.getAvatar()+".png"));
            f.username.setText(user.getUserName());
            f.im_accept.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        DAO.getInstance().AcceptFriendReq(user.getId());
                        obj.users.getChildren().remove(f);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            f.im_reject.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        DAO.getInstance().DeleteFriendReq(user.getId());
                        obj.users.getChildren().remove(f);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            obj.users.getChildren().add(f);
        }

    }
}
