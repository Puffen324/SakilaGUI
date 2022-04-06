package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.*;
import com.yaelev.sakilagui.entity.Customer;
import com.yaelev.sakilagui.entity.Inventory;
import com.yaelev.sakilagui.entity.Rental;
import com.yaelev.sakilagui.entity.Staff;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collections;
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
    @FXML
    private ComboBox<Staff> staffBox;
    @FXML
    private ComboBox<Customer> customerBox;
    @FXML
    private ComboBox<Inventory> invetoryBox;

    public void updateRentalTableView() {
        rentalTableView.setItems(FXCollections.observableList(new RentalDAO().read()));
        rentalIdColumn.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
        rentalDateColumn.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
        inventoryIdColumn.setCellValueFactory(new PropertyValueFactory<>("inventory"));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customer"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staff"));
        latestUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        rentalTableView.getItems().addAll();
    }
    private void fillStaffBox(){
        staffBox.setItems(FXCollections.observableList((new StaffDAO().read())));
        staffBox.getItems().addAll();
    }
    private void fillCustomerBox(){
        customerBox.setItems(FXCollections.observableList((new CustomerDAO().read())));
        customerBox.getItems().addAll();
    }
    private void fillInventoryBox(){
        //Inventory rental = new Inventory();
        invetoryBox.setItems(FXCollections.observableList((new InventoryDAO().read())));
        invetoryBox.getItems().addAll();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateRentalTableView();
        LocalDate date = LocalDate.now();
        todaysDate.setText(date.toString());
        fillStaffBox();
        fillCustomerBox();
        fillInventoryBox();
        //updateStaffEntityTableView();
    }
        //Backended ÄR inte klart ännu
    public void createRental(){
        Rental rental = new Rental();
        rental.setRentalDate(Timestamp.from(Instant.now()));
        //rental.setFilmId(invetoryBox.getSelectionModel().getSelectedItem().getFilmId());
       // inventory.setStore(storeCombobox.getSelectionModel().getSelectedItem());
        //inventory.setLastUpdate(Timestamp.from(Instant.now()));
        new RentalDAO().create(rental);

    }
    public void deleteRental(){

    }




    public void updateRentalDate(){}
    public void inventoryIdUpdate(){}
    public void customerIdUpdate(){}
    public void returnDateUpdate(){}
    public void staffIdUpdate(){}
    public void updateLastUpdate(){}
}
