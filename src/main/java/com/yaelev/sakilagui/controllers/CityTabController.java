package com.yaelev.sakilagui.controllers;



import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Country;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;

import javafx.scene.control.cell.PropertyValueFactory;

import com.yaelev.sakilagui.dao.CityDAO;
import com.yaelev.sakilagui.dao.CountryDAO;
import javafx.scene.control.cell.TextFieldTableCell;


public class CityTabController implements  Initializable {
    @FXML
    private TableView<City> cityTableView;
    @FXML
    private TableColumn<City, Integer> cityIdColumn;
    @FXML
    private TableColumn<City, String> cityNameColumn;
    @FXML
    private TableColumn<City, Country> countryColumn;
    @FXML
    private TableColumn<City, Timestamp> cityLastUpdateColumn;
    @FXML
    private ChoiceBox<Country> countryChoiceBox;
    @FXML
    private TextField cityTextField;


    //Backended ÄR inte klart ännu


    public void updateCityTableView() {
        cityTableView.setItems(FXCollections.observableList(new CityDAO().read()));
        cityIdColumn.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        cityNameColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        cityNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
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

    public void deleteCity() {
        City city = cityTableView.getSelectionModel().getSelectedItem();
        new CityDAO().delete(city);
        updateCityTableView();

    }


public void createCity() {
    if (cityTextField != null && countryChoiceBox != null) {
        City city = new City(cityTextField.getText(),
                countryChoiceBox.getSelectionModel().getSelectedItem());

        new CityDAO().create(city);
        updateCityTableView();
        cityTextField.setText("");



    }
    }
    public void editCityName(TableColumn.CellEditEvent<City,String> cityStringCellEditEvent){
        cityTableView.getSelectionModel().getSelectedItem().setCity(cityStringCellEditEvent.getNewValue());
        cityTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        new CityDAO().update(cityTableView.getSelectionModel().getSelectedItem());
        updateCityTableView();
    }
}
