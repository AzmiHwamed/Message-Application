package com.example.messageapplication.UI;
import com.example.messageapplication.Controllers.AllUsersController;
import com.example.messageapplication.Models.User;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class UsersParent extends BorderPane {
        public VBox users;
    Image search_im;
    ImageView search_view;
    TextField search_box;
    HBox search;
    ScrollPane scrollPane ;
    public UsersParent() throws SQLException {
        this.setMinSize(1200,700);
        this.setMaxSize(1200,700);
        search=new HBox();
        search.setSpacing(10);
        search_im=new Image("search.png");
        search_view=new ImageView(search_im);
        search_view.setFitHeight(20);
        search_view.setFitWidth(20);
        search_box=new TextField();
        search_box.prefWidthProperty().bind(this.widthProperty());
        search_box.setPromptText("Search here");
        search.getChildren().addAll(search_view,search_box);
        search.setPadding(new Insets(30));
        search.prefWidthProperty().bind(this.widthProperty());
        scrollPane=new ScrollPane();

        users=new VBox();
        users.setSpacing(20);
        users.setPadding(new Insets(30));
        users.getChildren().addAll(new AppUser(),new AppUser(),new AppUser(),new AppUser(),new AppUser(),new AppUser(),new AppUser(),new AppUser(),new AppUser(),new AppUser(),new AppUser(),new AppUser());
        scrollPane.setContent(users);
        scrollPane.setFitToWidth(true);
        this.setTop(search);
        ScrollPane x=new ScrollPane(users);
        x.setFitToWidth(true);
        this.setCenter(x);
        this.setBottom(new BottomNavigation());
        new AllUsersController(this).onCreate();

    }
}
