module com.example.messageapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires com.google.gson;



    opens com.example.messageapplication to javafx.fxml;
    opens com.example.messageapplication.Models to com.google.gson;
    exports com.example.messageapplication;
    exports com.example.messageapplication.Controllers;
    opens com.example.messageapplication.Controllers to javafx.fxml;
}