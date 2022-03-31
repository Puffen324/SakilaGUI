package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.entity.ActorEntity;
import com.yaelev.sakilagui.entity.AddressEntity;
import com.yaelev.sakilagui.entity.StaffEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class SaffTabContorller implements Initializable {
    @FXML
    private TableView<StaffEntity> staffEntityTableView;
    @FXML
    private TableColumn<StaffEntity, Integer> staffIdColumn;
    @FXML
    private TableColumn<StaffEntity,String> staffNameColumn;
    @FXML
    private TableColumn<StaffEntity,String> staffLastnameColumn;
    @FXML
    private TableColumn<StaffEntity,Integer> address_idColumn;
    @FXML
    private TableColumn<StaffEntity,String> staffEmailColumn1;
    @FXML
    private TableColumn<StaffEntity,Integer>store_IdColumn;
    @FXML
    private TableColumn<StaffEntity,String> userColumn;
    @FXML
    private TableColumn<StaffEntity,String> passwordColumn;
    @FXML
    private TableColumn<StaffEntity, Timestamp> staffLastUpdateColumn;

    public void updateStaffEntityTableView(){
        //Backended ÄR inte klart ännu

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //updateStaffEntityTableView();
    }
    public void updateStaffName(){}
    public void updateStaffLastName(){}
    public void updateStaffaddress_id(){}
    public void updateStaffEmail(){}
    public void updateStoreID(){}
    public void updateUser(){}
    public void updatePassword(){}
    public void updateLastUpdate(){}
}
