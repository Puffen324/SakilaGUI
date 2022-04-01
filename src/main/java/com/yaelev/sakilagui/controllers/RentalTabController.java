package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.entity.Rental;
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
    private TableView<Rental> rentalEntityTableView;
    @FXML
    private TableColumn<Rental, Integer> rentalIdColumn;
    @FXML
    private TableColumn<Rental, Timestamp> rentalDateColumn;
    @FXML
    private TableColumn<Rental,Integer> inventoryIdColumn;
    @FXML
    private TableColumn<Rental,Integer> customerIdColumn;
    @FXML
    private TableColumn<Rental,Timestamp> returnDateColumn;
    @FXML
    private TableColumn<Rental,Integer> staffIdColumn;
    @FXML
    private TableColumn<Rental,Timestamp> latestUpdateColumn;

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
