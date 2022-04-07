package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.*;
import com.yaelev.sakilagui.entity.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class RentalTabController implements Initializable {

    private RentalDAO rentalDAO = new RentalDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private InventoryDAO inventoryDAO = new InventoryDAO();
    private FilmDAO filmDAO = new FilmDAO();
    private StoreDAO storeDAO = new StoreDAO();

    @FXML
    private Label date;
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
    private TableColumn<Rental, Timestamp> lastUpdateColumn;
    @FXML
    private ComboBox<Customer> customerBox;
    @FXML
    private ComboBox<Inventory> inventoryComboBox;
    @FXML
    private ComboBox<Film> filmComboBox;
    @FXML
    private ComboBox<Store> storeComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupTableView();
        date.setText(String.valueOf(LocalDate.now()));
    }

    public void updateRentalTableView() {
        rentalTableView.setItems(FXCollections.observableList(rentalDAO.read()));
        rentalTableView.getItems().addAll();
    }

    public void setupTableView(){
        rentalTableView.setItems(FXCollections.observableList(rentalDAO.read()));
        rentalIdColumn.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
        rentalDateColumn.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
        inventoryIdColumn.setCellValueFactory(new PropertyValueFactory<>("inventory"));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customer"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staff"));
        lastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        rentalTableView.getItems().addAll();
    }

    @FXML
    private void updateCustomerComboBox() {
        customerBox.setItems(FXCollections.observableList((customerDAO.read())));
    }

    @FXML
    private void updateInventoryComboBox() {
        if (filmComboBox.getSelectionModel().getSelectedItem() != null) {
            List<Inventory> inventoryList = inventoryDAO
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
    private void updateFilmComboBox() {
        if (storeComboBox.getSelectionModel().getSelectedItem() != null) {
            List<Film> filmList = filmDAO.read();
            List<Inventory> storeInventoryList = storeComboBox.getSelectionModel().getSelectedItem().getInventoryList();
            List<Film> filteredList = filmList.stream()
                    .filter(film -> storeInventoryList.stream()
                            .anyMatch(inventory -> inventory.getFilmId() == (film.getFilmId())))
                    .collect(Collectors.toList());
            filmComboBox.setItems(FXCollections.observableArrayList(filteredList));
        }
    }

    @FXML
    private void updateStoreComboBox() {
        storeComboBox.setItems(FXCollections.observableList(storeDAO.read()));
    }


    public void createRental() {
        Rental rental = new Rental();
        rental.setRentalDate(Timestamp.from(Instant.now()));
        rental.setCustomer(customerBox.getSelectionModel().getSelectedItem());
        rental.setStaff(storeComboBox.getSelectionModel().getSelectedItem().getStaff());
        rental.setInventory(inventoryComboBox.getSelectionModel().getSelectedItem());
        rental.setReturnDate(Timestamp.from(Instant.now().plus(filmComboBox.getSelectionModel().getSelectedItem().getRentalDuration(), ChronoUnit.DAYS)));
        rental.setLastUpdate(Timestamp.from(Instant.now()));
        rentalDAO.create(rental);
        updateRentalTableView();
    }

    public void deleteRental() {
        Rental rental = rentalTableView.getSelectionModel().getSelectedItem();
        rentalDAO.delete(rental);
        updateRentalTableView();
    }

}
