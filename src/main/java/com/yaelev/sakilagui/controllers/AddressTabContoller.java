package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.entity.Address;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class AddressTabContoller  implements Initializable {
    @FXML
    private TableView<Address> addressEntityTableView;

    @FXML
    private TableColumn<Address, Integer> addressIdColumn;

    @FXML
    private TableColumn<Address, String> addressNameColumn;

    @FXML
    private TableColumn<Address, String> districtColumn;
    @FXML
    private TableColumn<Address, Integer> city_idColumn;
    @FXML
    private TableColumn<Address, Integer> postalCodeColumn1;
    @FXML
    private TableColumn<Address, Integer> phoneColumn11;
    @FXML
    private TableColumn<Address, Integer> locationColumn111;
    @FXML
    private TableColumn<Address, Timestamp> actorLastUpdateColumn;

    public void updateAddressEntityTableView(){
        //Backended ÄR inte klart ännu

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //updateAddressEntityTableView();
    }
    public void updateAddress(){

    }
    public void updateDistrict(){

    }
    public void updateCity_id(){

    }
    public void updatePostalCode(){

    }
    public void updatePhone(){

    }
    public void updateLocation(){

    }
    public void updateLastUpdate(){

    }
}


























