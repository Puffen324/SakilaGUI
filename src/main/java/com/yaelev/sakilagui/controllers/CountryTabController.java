package com.yaelev.sakilagui.controllers;


import com.yaelev.sakilagui.entity.Country;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class CountryTabController implements Initializable {
    @FXML
    private TableView<Country> countryEntityTableViewEntityTableView;

    @FXML
    private TableColumn<Country, Integer> countryIdColumn;

    @FXML
    private TableColumn<Country, String> countryNameColumn;


    @FXML
    private TableColumn<Country, Timestamp> countryLastUpdateColumn;

    public void updateCountryEntityTableView() {
        //Backended ÄR inte klart ännu

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
