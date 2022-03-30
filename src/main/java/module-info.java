module com.yaelev.sakilagui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.yaelev.sakilagui to javafx.fxml;
    exports com.yaelev.sakilagui;
}