package com.example.messageapplication.UI;

import com.example.messageapplication.Controllers.SignInController;
import com.example.messageapplication.Navigator.Navigator;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SignInParent extends BorderPane {
public TextField email;
public PasswordField password;
public VBox sign_in;
public Button signin;
public Image im_logo;
public ImageView logo;
public Label sign_up;
public Text t1;
public Text t2;
public Text t3;
public TextFlow txt;
public VBox btn_box;
    public SignInParent() {
        email=new TextField();
        email.setPromptText("E_mail");
        email.setPrefSize(1028,40);
        password=new PasswordField();
        password.setPrefSize(1028,40);
        password.setPromptText("password");
        sign_in=new VBox();
        sign_in.setPadding(new Insets(40,100,40,100));
        sign_in.setSpacing(100);
        sign_in.setAlignment(Pos.TOP_CENTER);
        signin=new Button("Sign In");
        signin.setOnAction(new SignInController(this));
        signin.setPrefSize(1028,30);
       signin.setStyle("-fx-background-color: #6087EB; -fx-text-fill: white;");
        signin.prefWidthProperty().bind(sign_in.widthProperty());
        im_logo=new Image("C:\\Users\\ASUS\\IdeaProjects\\Message-Application\\src\\main\\resources\\plogo.png");
        logo=new ImageView(im_logo);
        logo.setFitHeight(100);
        logo.setFitWidth(300);
        t1=new Text("You don't have an account? ");
        t2=new Text("Sign up ");
        t2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Navigator.getInstance().showScene("signup");
            }
        });
        t2.setFill(Color.web("#6087EB"));
        t2.setCursor(Cursor.HAND);
        t3=new Text("now for free");
        txt=new TextFlow(t1,t2,t3);
        sign_up=new Label();
        sign_up.setGraphic(txt);
        btn_box=new VBox();
        btn_box.setSpacing(30);
        btn_box.getChildren().addAll(signin,sign_up);
        btn_box.setAlignment(Pos.CENTER);

        sign_in.getChildren().addAll(logo,email,password,btn_box);

        this.setCenter(sign_in);
        this.setMinSize(1200,700);
        this.setMaxSize(1200,700);
        //this.setBottom(new BottomNavigation());

    }
}
