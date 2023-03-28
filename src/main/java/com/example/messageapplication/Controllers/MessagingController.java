package com.example.messageapplication.Controllers;

import com.example.messageapplication.DAO.DAO;
import com.example.messageapplication.Models.CurrentChatBuddy;
import com.example.messageapplication.Models.CurrentUser;
import com.example.messageapplication.Models.Message;
import com.example.messageapplication.Models.User;
import com.example.messageapplication.Translator.Translator;
import com.example.messageapplication.UI.FirendUI;
import com.example.messageapplication.UI.IncomingMessage;
import com.example.messageapplication.UI.MessagingParent;
import com.example.messageapplication.UI.MyMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.ArrayList;

public class MessagingController implements EventHandler<ActionEvent> {
    MessagingParent obj;
    ArrayList<User> friends;

    public MessagingController(MessagingParent obj) {
        this.obj = obj;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
    public  void onCreate() throws SQLException {
        obj.listOfFriendsContent.getChildren().clear();
        friends = DAO.getInstance().getFriends();
        for(int i=0;i< friends.size();i++){
            FirendUI x=new FirendUI(friends.get(i).getUserName(),friends.get(i).getAvatar());
            int finalI = i;
            x.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        ChangeChatBuddy(friends.get(finalI));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            obj.listOfFriendsContent.getChildren().add(x);
        }
    }

    private void ChangeChatBuddy(User user) throws Exception {
        obj.UserName.setText(user.getUserName());
        obj.av_im.setImage(new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\"+user.getAvatar()+".png"));
        obj.MessagingMain.getChildren().clear();
        ArrayList<Message> messages=DAO.getInstance().getMessages(user.getId());
        for(int i =0;i<messages.size();i++){
            System.out.println("fema for");
            if(messages.get(i).Sender.equals(Integer.toString(CurrentUser.GetCurrentUser().getId()))){
                obj.MessagingMain.getChildren().add(new MyMessage(messages.get(i).message));
            }
            else{
                obj.MessagingMain.getChildren().add(new IncomingMessage(Translator.translate(DAO.getInstance().GetUserById(Integer.parseInt(messages.get(i).Sender)).getLang(),DAO.getInstance().GetUserById(Integer.parseInt(messages.get(i).Reciever)).getLang(),messages.get(i).message)));
            }
        }
        obj.x.setVvalue(1.0);
        CurrentChatBuddy.SetUser(user);
        System.out.println("chatbuddy id= "+CurrentChatBuddy.GetCurrentUser().getId());
        System.out.println("user  id= "+CurrentUser.GetCurrentUser().getId());
    }
}
