package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.*;
import com.yaelev.sakilagui.entity.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
    private TableColumn<Rental, Inventory> inventoryIdColumn;
    @FXML
    private TableColumn<Rental, Customer> customerIdColumn;
    @FXML
    private TableColumn<Rental, Timestamp> returnDateColumn;
    @FXML
    private TableColumn<Rental, Staff> staffIdColumn;
    @FXML
    private TableColumn<Rental, Timestamp> latestUpdateColumn;

    @FXML
    private ComboBox<Customer> customerBox;
    @FXML
    private ComboBox<Inventory> inventoryComboBox;
    @FXML
    private ComboBox<Film> filmComboBox;
    @FXML
    private ComboBox<Store> storeComboBox;
    @FXML
    private DatePicker pickADate;

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

    @FXML
    private void fillCustomerBox() {
        customerBox.setItems(FXCollections.observableList((new CustomerDAO().read())));
    }

    @FXML
    private void fillInventoryBox() {
        if (filmComboBox.getSelectionModel().getSelectedItem() != null) {
            List<Inventory> inventoryList = new InventoryDAO()
                    .read()
                    .stream()
                    .filter(e -> e.getFilmId() ==
                            filmComboBox.getSelectionModel()
                                    .getSelectedItem()
                                    .getFilmId()
                            &&
                            e.getStore().getStoreId() ==
                                    storeComboBox.getSelectionModel()
                                    .getSelectedItem().getStoreId())
                    .collect(Collectors.toList());
            inventoryComboBox.setItems(FXCollections.observableArrayList(inventoryList));
        }
    }

    @FXML
    private void fillFilmComboBox() {
        if (storeComboBox.getSelectionModel().getSelectedItem() != null) {
            List<Film> filmList = new FilmDAO().read();
            List<Inventory> storeInventoryList = storeComboBox.getSelectionModel().getSelectedItem().getInventoryList();
            List<Film> filteredList = filmList.stream()
                    .filter(film -> storeInventoryList.stream()
                            .anyMatch(inventory -> inventory.getFilmId() == (film.getFilmId())))
                    .collect(Collectors.toList());
            filmComboBox.setItems(FXCollections.observableArrayList(filteredList));
        }
    }

    @FXML
    private void fillStoreComboBox() {
        storeComboBox.setItems(FXCollections.observableList(new StoreDAO().read()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateRentalTableView();
        LocalDate date = LocalDate.now();
        todaysDate.setText(date.toString());
    }

    //Backended ÄR inte klart ännu
    public void createRental() {
        Rental rental = new Rental();
        rental.setRentalDate(Timestamp.from(Instant.now()));
        rental.setReturnDate(Timestamp.valueOf(pickADate.getValue().atStartOfDay()));
        rental.setCustomer(customerBox.getSelectionModel().getSelectedItem());
        rental.setStaff(storeComboBox.getSelectionModel().getSelectedItem().getStaff());
        rental.setInventory(inventoryComboBox.getSelectionModel().getSelectedItem());
        rental.setLastUpdate(Timestamp.from(Instant.now()));
        new RentalDAO().create(rental);
        updateRentalTableView();
    }

    public void deleteRental() {


        Rental rental = rentalTableView.getSelectionModel().getSelectedItem();
        new RentalDAO().delete(rental);
        updateRentalTableView();
    }


    public void updateRentalDate() {
    }

    public void inventoryIdUpdate() {
    }

    public void customerIdUpdate() {
    }

    public void returnDateUpdate() {
    }

    public void staffIdUpdate() {
    }

    public void updateLastUpdate() {
    }
}
