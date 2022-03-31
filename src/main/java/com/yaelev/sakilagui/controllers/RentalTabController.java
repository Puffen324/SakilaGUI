package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.entity.RentalEntity;
import com.yaelev.sakilagui.entity.StaffEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RentalTabController implements Initializable {
    @FXML
    Label todaysDate;
    @FXML
    private TableView<RentalEntity> rentalEntityTableView;
    @FXML
    private TableColumn<RentalEntity, Integer> rentalIdColumn;
    @FXML
    private TableColumn<RentalEntity, Timestamp> rentalDateColumn;
    @FXML
    private TableColumn<RentalEntity,Integer> inventoryIdColumn;
    @FXML
    private TableColumn<RentalEntity,Integer> customerIdColumn;
    @FXML
    private TableColumn<RentalEntity,Timestamp> returnDateColumn;
    @FXML
    private TableColumn<RentalEntity,Integer> staffIdColumn;
    @FXML
    private TableColumn<RentalEntity,Timestamp> latestUpdateColumn;

    public void updateStaffEntityTableView(){
        //Backended ÄR inte klart ännu

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate date = LocalDate.now();
        todaysDate.setText(date.toString());
        //updateStaffEntityTableView();
    }
    public void updateRentalDate(){}
    public void inventoryIdUpdate(){}
    public void customerIdUpdate(){}
    public void returnDateUpdate(){}
    public void staffIdUpdate(){}
    public void updateLastUpdate(){}
}
