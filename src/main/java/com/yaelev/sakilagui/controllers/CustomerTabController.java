package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.AddressDAO;
import com.yaelev.sakilagui.dao.CustomerDAO;
import com.yaelev.sakilagui.dao.StoreDAO;
import com.yaelev.sakilagui.entity.Address;
import com.yaelev.sakilagui.entity.Customer;
import com.yaelev.sakilagui.entity.Store;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerTabController implements Initializable {

    private AddressDAO addressDAO = new AddressDAO();
    private StoreDAO storeDAO = new StoreDAO();
    private CustomerDAO customerDAO = new CustomerDAO();

    @FXML
    private TableView<Customer> customerTableView;
    @FXML
    private TableColumn<Customer, Integer> customerIdColumn;
    @FXML
    private TableColumn<Customer, Store> storeColumn;
    @FXML
    private TableColumn<Customer, String> customerFirstNameColumn;
    @FXML
    private TableColumn<Customer, Timestamp> lastUpdateColumn;
    @FXML
    private TableColumn<Customer, String> customerLastNameColumn;
    @FXML
    private TableColumn<Customer, String> emailColumn;
    @FXML
    private TableColumn<Customer, Address> addressColumn;
    @FXML
    private TableColumn<Customer, Boolean> activeColumn;
    @FXML
    private TableColumn<Customer, Timestamp> createDateColumn;


    @FXML
    private TextField firstNameConstructor;
    @FXML
    private TextField lastNameConstructor;
    @FXML
    private TextField emailConstructor;
    @FXML
    private ChoiceBox<Store> storeChoiceBox;
    @FXML
    private ChoiceBox<Address> addressChoiceBox;
    @FXML
    private ChoiceBox<Boolean> booleanChoiceBox = new ChoiceBox<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateBooleanChoiceBox();
        updateAddressChoiceBox();
        setUpCustomerTableView();
        updateStoreChoiceBox();


    }

    public void setUpCustomerTableView() {
        customerTableView.setItems(FXCollections.observableList(new CustomerDAO().read()));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        storeColumn.setCellValueFactory(new PropertyValueFactory<>("store"));
        customerFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        customerFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        customerLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        customerLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressColumn.setCellFactory(ChoiceBoxTableCell.forTableColumn(addressChoiceBox.getItems()));

        activeColumn.setCellValueFactory(param -> param.getValue().getObsBoolean());
        activeColumn.setCellFactory(ChoiceBoxTableCell.forTableColumn(booleanChoiceBox.getItems()));

        createDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        lastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        customerTableView.getItems().addAll();
    }

    public void updateCustomerTableView() {
        customerTableView.setItems(FXCollections.observableList(customerDAO.read()));
        customerTableView.getItems().addAll();
    }

    public void createCustomer() {
        if (firstNameConstructor != null &&
                lastNameConstructor != null &&
                storeChoiceBox != null &&
                addressChoiceBox != null) {
            Customer customer = new Customer(firstNameConstructor.getText(),
                    lastNameConstructor.getText(),
                    emailConstructor.getText(),
                    addressChoiceBox.getSelectionModel().getSelectedItem(),
                    storeChoiceBox.getSelectionModel().getSelectedItem(),
                    true);

            new CustomerDAO().create(customer);
            updateCustomerTableView();
            firstNameConstructor.setText("");
            lastNameConstructor.setText("");
            emailConstructor.setText("");
        }

    }

    public void deleteCustomer() {
        Customer customer = customerTableView.getSelectionModel().getSelectedItem();
        customerDAO.delete(customer);
        updateCustomerTableView();
    }

    public void editFirstName(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
        customerTableView.getSelectionModel().getSelectedItem().setFirstName(customerStringCellEditEvent.getNewValue());
        customerTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        customerDAO.update(customerTableView.getSelectionModel().getSelectedItem());
        updateCustomerTableView();
    }

    public void editLastName(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
        customerTableView.getSelectionModel().getSelectedItem().setLastName(customerStringCellEditEvent.getNewValue());
        customerTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        customerDAO.update(customerTableView.getSelectionModel().getSelectedItem());
        updateCustomerTableView();
    }

    public void editEmail(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
        customerTableView.getSelectionModel().getSelectedItem().setEmail(customerStringCellEditEvent.getNewValue());
        customerTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        customerDAO.update(customerTableView.getSelectionModel().getSelectedItem());
        updateCustomerTableView();
    }

    public void editAddress(TableColumn.CellEditEvent<Customer, Address> customerAddressCellEditEvent) {
        customerTableView.getSelectionModel().getSelectedItem().setAddress(customerAddressCellEditEvent.getNewValue());
        customerTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        customerDAO.update(customerTableView.getSelectionModel().getSelectedItem());
        updateCustomerTableView();
    }

    public void editActive(TableColumn.CellEditEvent<Customer, Boolean> customerBooleanCellEditEvent) {
        customerTableView.getSelectionModel().getSelectedItem().setActive(customerBooleanCellEditEvent.getNewValue());
        customerTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        customerDAO.update(customerTableView.getSelectionModel().getSelectedItem());
        updateCustomerTableView();
    }


    public void updateBooleanChoiceBox() {
        List<Boolean> booleans = new ArrayList<>();
        booleans.add(true);
        booleans.add(false);
        booleanChoiceBox.setItems(FXCollections.observableArrayList(booleans));
    }

    public void updateAddressChoiceBox() {
        addressChoiceBox.setItems(FXCollections.observableArrayList(addressDAO.read()));
    }

    public void updateStoreChoiceBox() {
        storeChoiceBox.setItems(FXCollections.observableArrayList(storeDAO.read()));
    }


}
