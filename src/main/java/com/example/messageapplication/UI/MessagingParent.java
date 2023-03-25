package com.example.messageapplication.UI;

import com.example.messageapplication.Models.User;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MessagingParent extends BorderPane {
    BorderPane listOfFriends;
    public ImageView SearchBtn;
    HBox searchHeader;
    TextField SearchBar;
    VBox listOfFriendsContent;
    BorderPane CoreMessaging;
    HBox MessagingHeader;
    VBox MessagingMain;
    GridPane SendBar;
    Text UserName;
    TextField MessageTextField;
    ImageView Send;

    public MessagingParent() {
        Image image1 = new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\send.png");
        listOfFriends=new BorderPane();
        searchHeader=new HBox();
        SearchBar=new TextField();
        SearchBar.setPrefWidth(1000);
        SearchBar.setPromptText("Seach ...");
        listOfFriendsContent=new VBox();
        SearchBtn=new ImageView(new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\search.png"));
        SearchBtn.setFitWidth(30);
        SearchBtn.setFitHeight(30);
        SearchBtn.setCursor(Cursor.HAND);
        searchHeader.setPadding(new Insets(5));
        searchHeader.getChildren().addAll(SearchBar,SearchBtn);
        listOfFriends.setTop(searchHeader);
        ScrollPane y =new ScrollPane(listOfFriendsContent);
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
        MessagingHeader.getChildren().add(UserName);
        SendBar.add(MessageTextField,0,0,2,1);
        SendBar.add(Send,2,0,1,1);
        SendBar.setMinWidth(500);
        CoreMessaging.setTop(MessagingHeader);
        ScrollPane x =new ScrollPane(MessagingMain);
        x.setFitToWidth(true);
        CoreMessaging.setCenter(x);

        MessagingMain.setPrefWidth(600);
        MessagingMain.setSpacing(10);
        CoreMessaging.setBottom(SendBar);
        this.setCenter(new SplitPane(listOfFriends,CoreMessaging));
        this.setBottom(new BottomNavigation());
        this.setPrefSize(1000,700);
        for(int i =0;i<20;i++){
            MessagingMain.getChildren().add(new MyMessage("hello"));
            MessagingMain.getChildren().add(new IncomingMessage("hello"));
        }
        for(int i =0;i<20;i++){
            listOfFriendsContent.getChildren().add(new FirendUI("Rihem"));
        }






    }
}
