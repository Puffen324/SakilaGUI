module com.yaelev.sakilagui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;


    opens com.yaelev.sakilagui to javafx.fxml;
    exports com.yaelev.sakilagui;
    exports com.yaelev.sakilagui.controllers;
    opens com.yaelev.sakilagui.controllers to javafx.fxml;

}