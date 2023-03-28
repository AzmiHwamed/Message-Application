package com.example.messageapplication.Controllers;

import com.example.messageapplication.DAO.DAO;
import com.example.messageapplication.Models.CurrentUser;
import com.example.messageapplication.Models.User;
import com.example.messageapplication.UI.AppUser;
import com.example.messageapplication.UI.FriendReq;
import com.example.messageapplication.UI.UsersParent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

public class AllUsersController {
    static UsersParent obj;

    public AllUsersController( UsersParent obj) {
        this.obj=obj;
    }

    public static void onCreate() throws SQLException {
        obj.users.getChildren().clear();
        ArrayList<User> fr= DAO.getInstance().getNonriends();
        System.out.println(CurrentUser.GetCurrentUser().getId());
        System.out.println(fr);
        for(User user:fr){
            AppUser f=new AppUser();
            f.av_im.setImage(new Image(user.getAvatar()+".png"));
            f.username.setText(user.getUserName());
            f.im_add.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    DAO.getInstance().sendReq(user.getId());
                    obj.users.getChildren().remove(f);
                }
            });
            obj.users.getChildren().add(f);
        }

    }
}
