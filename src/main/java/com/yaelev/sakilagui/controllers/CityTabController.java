package com.yaelev.sakilagui.controllers;



import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Country;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;

import javafx.scene.control.cell.PropertyValueFactory;

import com.yaelev.sakilagui.dao.CityDAO;
import com.yaelev.sakilagui.dao.CountryDAO;



public class CityTabController implements  Initializable{
    @FXML
    private TableView<City> cityTableView;
    @FXML
    private TableColumn<City, Integer> cityIdColumn;
    @FXML
    private TableColumn<City, String> cityNameColumn;
    @FXML
    private TableColumn<Country, Integer> countryIdColumn;
    @FXML
    private TableColumn<City, Timestamp> cityLastUpdateColumn;
    @FXML
    private ChoiceBox<Country> countryChoiceBox;





    //Backended ÄR inte klart ännu





    public void updateCityTableView(){
        cityTableView.setItems(FXCollections.observableList(new CityDAO().read()));
        cityIdColumn.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        cityNameColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        countryIdColumn.setCellValueFactory(new PropertyValueFactory<>("countryId"));
        cityLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        cityTableView.getItems().addAll();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCityTableView();
        updateCountryBox();
    }
    public void updateCountryBox() {
        countryChoiceBox.setItems(FXCollections.observableList(new CountryDAO().read()));
        countryChoiceBox.getItems().addAll();

    }
    public void updateCity_id() {

    }

    public void updateCity() {

    }

    public void updateCountry_id() {

    }

    public void updateLastUpdate() {

    }
}



