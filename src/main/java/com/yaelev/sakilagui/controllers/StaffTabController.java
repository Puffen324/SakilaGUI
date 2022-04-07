package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.StaffDAO;
import com.yaelev.sakilagui.entity.Address;
import com.yaelev.sakilagui.entity.Staff;
import com.yaelev.sakilagui.entity.Store;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class StaffTabController implements Initializable {

    private StaffDAO staffDAO = new StaffDAO();

    @FXML
    private TableView<Staff> StaffTableView;
    @FXML
    private TableColumn<Staff, Integer> staffIdColumn;
    @FXML
    private TableColumn<Staff,String> staffNameColumn;
    @FXML
    private TableColumn<Staff,String> staffLastnameColumn;
    @FXML
    private TableColumn<Staff, Address> addressColumn;
    @FXML
    private TableColumn<Staff,String> staffEmailColumn1;
    @FXML
    private TableColumn<Staff, Store> storeColumn;
    @FXML
    private TableColumn<Staff,String> userColumn;
    @FXML
    private TableColumn<Staff,String> passwordColumn;
    @FXML
    private TableColumn<Staff, Timestamp> staffLastUpdateColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupStaffTableView();
    }

    public void updateStaffTableView(){
        StaffTableView.setItems(FXCollections.observableList(staffDAO.read()));
        StaffTableView.getItems().addAll();
    }

    public void setupStaffTableView(){
        StaffTableView.setItems(FXCollections.observableList(staffDAO.read()));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        staffNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        staffLastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        staffEmailColumn1.setCellValueFactory(new PropertyValueFactory<>("email"));
        storeColumn.setCellValueFactory(new PropertyValueFactory<>("store"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        staffLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        StaffTableView.getItems().addAll();
    }


    public void removeStaff(){
        Staff staff = StaffTableView.getSelectionModel().getSelectedItem();
        staffDAO.delete(staff);
        updateStaffTableView();
    }

    public void updateStaffName(){

    }
    public void updateStaffLastName(){

    }
    public void updateStaffAddress(){

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
