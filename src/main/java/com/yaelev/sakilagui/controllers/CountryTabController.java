package com.yaelev.sakilagui.controllers;


import com.yaelev.sakilagui.dao.ActorDAO;
import com.yaelev.sakilagui.dao.CountryDAO;
import com.yaelev.sakilagui.entity.Country;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class CountryTabController implements Initializable {

    // Detta är en lookup tabell, ingen data i denna bör kunna ändras.
    // Vi kan eventuellt lägga till en sökfunktion ifall vi har tid över.
    
    @FXML
    private TableView<Country> countryTableView;

    @FXML
    private TableColumn<Country, Integer> countryIdColumn;

    @FXML
    private TableColumn<Country, String> countryNameColumn;

    @FXML
    private TableColumn<Country, Timestamp> countryLastUpdateColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCountryTableView();
    }

    public void updateCountryTableView(){
        countryTableView.setItems(FXCollections.observableList(new CountryDAO().read()));
        countryIdColumn.setCellValueFactory(new PropertyValueFactory<>("countryId"));
        countryNameColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        countryLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        countryTableView.getItems().addAll();
    }
}
