package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.CityDAO;
import com.yaelev.sakilagui.dao.RentalDAO;
import com.yaelev.sakilagui.entity.Customer;
import com.yaelev.sakilagui.entity.Inventory;
import com.yaelev.sakilagui.entity.Rental;
import com.yaelev.sakilagui.entity.Staff;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RentalTabController implements Initializable {
    @FXML
    Label todaysDate;
    @FXML
    private TableView<Rental> rentalTableView;
    @FXML
    private TableColumn<Rental, Integer> rentalIdColumn;
    @FXML
    private TableColumn<Rental, Timestamp> rentalDateColumn;
    @FXML
    private TableColumn<Rental,Inventory> inventoryIdColumn;
    @FXML
    private TableColumn<Rental,Customer> customerIdColumn;
    @FXML
    private TableColumn<Rental,Timestamp> returnDateColumn;
    @FXML
    private TableColumn<Rental,Staff> staffIdColumn;
    @FXML
    private TableColumn<Rental,Timestamp> latestUpdateColumn;

    public void updateRentalTableView() {
        rentalTableView.setItems(FXCollections.observableList(new RentalDAO().read()));
        rentalIdColumn.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
        rentalDateColumn.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
        inventoryIdColumn.setCellValueFactory(new PropertyValueFactory<>("inventoryId"));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        latestUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("latestUpdate"));

        rentalTableView.getItems().addAll();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateRentalTableView();
        LocalDate date = LocalDate.now();
        todaysDate.setText(date.toString());
        //updateStaffEntityTableView();
    }
        //Backended ÄR inte klart ännu





    public void updateRentalDate(){}
    public void inventoryIdUpdate(){}
    public void customerIdUpdate(){}
    public void returnDateUpdate(){}
    public void staffIdUpdate(){}
    public void updateLastUpdate(){}
}
