module com.yaelev.sakilagui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires jts;


    opens com.yaelev.sakilagui to javafx.fxml;
    opens com.yaelev.sakilagui.entity;
    exports com.yaelev.sakilagui;
    exports com.yaelev.sakilagui.controllers;
    opens com.yaelev.sakilagui.controllers to javafx.fxml;


}