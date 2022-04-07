package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.CountryDAO;
import com.yaelev.sakilagui.entity.Country;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class CountryTabController implements Initializable {

    private CountryDAO countryDAO = new CountryDAO();
    
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
        setupCountyTableView();
    }

    public void setupCountyTableView(){
        countryTableView.setItems(FXCollections.observableList(countryDAO.read()));
        countryIdColumn.setCellValueFactory(new PropertyValueFactory<>("countryId"));
        countryNameColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        countryLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        countryTableView.getItems().addAll();
    }
}
