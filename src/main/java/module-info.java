module com.example.messageapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.messageapplication to javafx.fxml;
    exports com.example.messageapplication;
    exports com.example.messageapplication.Controllers;
    opens com.example.messageapplication.Controllers to javafx.fxml;
}