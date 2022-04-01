package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.AddressDAO;
import com.yaelev.sakilagui.dao.StaffDAO;
import com.yaelev.sakilagui.entity.Staff;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class StaffTabContorller implements Initializable {
    @FXML
    private TableView<Staff> StaffTableView;
    @FXML
    private TableColumn<Staff, Integer> staffIdColumn;
    @FXML
    private TableColumn<Staff,String> staffNameColumn;
    @FXML
    private TableColumn<Staff,String> staffLastnameColumn;
    @FXML
    private TableColumn<Staff,Integer> address_idColumn;
    @FXML
    private TableColumn<Staff,String> staffEmailColumn1;
    @FXML
    private TableColumn<Staff,Integer>store_IdColumn;
    @FXML
    private TableColumn<Staff,String> userColumn;
    @FXML
    private TableColumn<Staff,String> passwordColumn;
    @FXML
    private TableColumn<Staff, Timestamp> staffLastUpdateColumn;

    public void updateStaffEntityTableView(){
        StaffTableView.setItems(FXCollections.observableList(new StaffDAO().read()));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        staffNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        staffLastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        address_idColumn.setCellValueFactory(new PropertyValueFactory<>("addressId"));
        staffEmailColumn1.setCellValueFactory(new PropertyValueFactory<>("email"));
        store_IdColumn.setCellValueFactory(new PropertyValueFactory<>("storeId"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        staffLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        StaffTableView.getItems().addAll();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateStaffEntityTableView();
    }
    public void updateStaffName(){

    }
    public void updateStaffLastName(){

    }
    public void updateStaffaddress_id(){

    }
    public void updateStaffEmail(){

    }
    public void updateStoreID(){

    }
    public void updateUser(){

    }
    public void updatePassword(){

    }
    public void updateLastUpdate(){

    }
}
