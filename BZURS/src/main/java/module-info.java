module com.example.bzurs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.bzurs to javafx.fxml;
    exports com.example.bzurs;
}