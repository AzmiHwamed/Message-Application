module com.example.messageapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.messageapplication to javafx.fxml;
    exports com.example.messageapplication;
}