package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.entity.ActorEntity;
import com.yaelev.sakilagui.entity.AddressEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class AddressTabContoller  implements Initializable {
    @FXML
    private TableView<AddressEntity> addressEntityTableView;

    @FXML
    private TableColumn<AddressEntity, Integer> addressIdColumn;

    @FXML
    private TableColumn<AddressEntity, String> addressNameColumn;

    @FXML
    private TableColumn<AddressEntity, String> districtColumn;
    @FXML
    private TableColumn<AddressEntity, Integer> city_idColumn;
    @FXML
    private TableColumn<AddressEntity, Integer> postalCodeColumn1;
    @FXML
    private TableColumn<AddressEntity, Integer> phoneColumn11;
    @FXML
    private TableColumn<AddressEntity, Integer> locationColumn111;
    @FXML
    private TableColumn<AddressEntity, Timestamp> actorLastUpdateColumn;

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


























