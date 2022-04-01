package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.AddressDAO;
import com.yaelev.sakilagui.dao.StoreDAO;
import com.yaelev.sakilagui.entity.Address;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Address, Timestamp> addressLastUpdateColumn1111;

    public void updateAddressEntityTableView(){
        addressEntityTableView.setItems(FXCollections.observableList(new AddressDAO().read()));
        addressIdColumn.setCellValueFactory(new PropertyValueFactory<>("addressId"));
        addressNameColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        districtColumn.setCellValueFactory(new PropertyValueFactory<>("district"));
        city_idColumn.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        postalCodeColumn1.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        phoneColumn11.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        locationColumn111.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        addressLastUpdateColumn1111.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        addressEntityTableView.getItems().addAll();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateAddressEntityTableView();
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


























