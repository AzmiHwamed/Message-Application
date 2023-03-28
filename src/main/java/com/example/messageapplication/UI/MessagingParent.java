package com.example.messageapplication.UI;

import com.example.messageapplication.Controllers.MessagingController;
import com.example.messageapplication.Models.CurrentChatBuddy;
import com.example.messageapplication.Models.CurrentUser;
import com.example.messageapplication.Models.User;
import com.example.messageapplication.Server.Client;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

public class MessagingParent extends BorderPane {
    BorderPane listOfFriends;
    public ImageView SearchBtn;
    public Client client;
    HBox searchHeader;
    TextField SearchBar;
    public VBox listOfFriendsContent;
    BorderPane CoreMessaging;
    public ScrollPane x;
    HBox MessagingHeader;
    public VBox MessagingMain;
    GridPane SendBar;

    public Text UserName;
    TextField MessageTextField;
    ImageView Send;
    public static MessagingParent obj;
    Image av_user;
    public ImageView av_im;

    public MessagingParent() throws IOException, SQLException {
        obj=this;
        av_user=new Image("1.png");
        av_im=new ImageView(av_user);
        av_im.setFitHeight(30);
        av_im.setFitWidth(30);
        Image image1 = new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\send.png");
        listOfFriends=new BorderPane();
        searchHeader=new HBox();
        SearchBar=new TextField();
        SearchBar.setMinHeight(20);
        SearchBar.setPrefWidth(1000);
        SearchBar.setPromptText("Seach ...");
        listOfFriendsContent=new VBox();
        SearchBtn=new ImageView(new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\search.png"));
        SearchBtn.setFitWidth(20);
        SearchBtn.setFitHeight(20);
        SearchBtn.setCursor(Cursor.HAND);
        searchHeader.setPadding(new Insets(5));
        searchHeader.getChildren().addAll(SearchBtn,SearchBar);
        searchHeader.setSpacing(5);
        listOfFriends.setTop(searchHeader);
        ScrollPane y =new ScrollPane(listOfFriendsContent);
        listOfFriendsContent.setPadding(new Insets(10));
        y.setFitToWidth(true);
        listOfFriends.setCenter(y);
        CoreMessaging=new BorderPane();
        MessagingHeader=new HBox();
        MessagingMain=new VBox();
        SendBar=new GridPane();
        UserName=new Text("Azmi");
        MessageTextField=new TextField();
        MessageTextField.setPrefWidth(1000);
        MessageTextField.setPromptText("Aa ..");
        Send=new ImageView(image1);
        Send.setCursor(Cursor.HAND);
        Send.setFitWidth(30);
        Send.setFitHeight(30);
        MessagingHeader.getChildren().addAll(av_im,UserName);
        MessagingHeader.setSpacing(10);
        MessagingHeader.setAlignment(Pos.CENTER_LEFT);
        SendBar.add(MessageTextField,0,0,2,1);
        SendBar.add(Send,2,0,1,1);
        SendBar.setMinWidth(500);
        CoreMessaging.setTop(MessagingHeader);
        x=new ScrollPane(MessagingMain);
        x.setFitToWidth(true);
        CoreMessaging.setCenter(x);
        MessagingMain.setPadding(new Insets(10));
        Send.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                client.sendMessage(Integer.toString(CurrentChatBuddy.GetCurrentUser().getId()),MessageTextField.getText());
                MessageTextField.setText("");
            }
        });
        MessagingMain.setPrefWidth(600);
        MessagingMain.setSpacing(10);
        CoreMessaging.setBottom(SendBar);
        this.setCenter(new SplitPane(listOfFriends,CoreMessaging));
        this.setBottom(new BottomNavigation());
        this.setMinSize(1200,700);
        this.setMaxSize(1200,700);








    }
    public void call() throws SQLException, IOException {
        new MessagingController(obj).onCreate();
        Socket socket=new Socket("localhost",1235);
        client =new Client(socket, Integer.toString(CurrentUser.GetCurrentUser().getId()),this);
        client.ListenForMessage();

    }
}
