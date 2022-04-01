package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Country;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class CityTabController implements Initializable {
    @FXML
    private TableView<City> cityEntityTableView;
    @FXML
    private TableColumn<City, Integer> cityIdColumn;
    @FXML
    private TableColumn<City, String> cityNameColumn;
    @FXML
    private TableColumn<City, Integer> countryIdColumn;
    @FXML
    private TableColumn<City, Timestamp> cityLastUpdateColumn;

    public void updateAddressEntityTableView(){
        //Backended ÄR inte klart ännu

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void updateCity_id(){

    }
    public void updateCity(){

    }
    public void updateCountry_id(){

    }
    public void updateLastUpdate(){

    }



public class CityTabController {

}
