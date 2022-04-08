package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.AddressDAO;
import com.yaelev.sakilagui.dao.CityDAO;
import com.yaelev.sakilagui.entity.Address;
import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Customer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ResourceBundle;

public class AddressTabController implements Initializable {

    private AddressDAO addressDAO = new AddressDAO();
    private CityDAO cityDAO = new CityDAO();

    @FXML
    private TableView<Address> addressTableView;
    @FXML
    private TableColumn<Address, Integer> addressIdColumn;
    @FXML
    private TableColumn<Address, String> addressNameColumn;
    @FXML
    private TableColumn<Address, String> districtColumn;
    @FXML
    private TableColumn<Address, City> cityColumn;
    @FXML
    private TableColumn<Address, String> postalCodeColumn;
    @FXML
    private TableColumn<Address, String> phoneColumn;
    @FXML
    private TableColumn<Address, Timestamp> addressLastUpdateColumn;
    @FXML
    private ChoiceBox<City> cityChoiceBox;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField districtTextField;

    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField postalCodeTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCityBox();
        setUpAddressTableView();
    }

    public void setUpAddressTableView() {
        addressTableView.setItems(FXCollections.observableList(addressDAO.read()));
        addressIdColumn.setCellValueFactory(new PropertyValueFactory<>("addressId"));

        addressNameColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        districtColumn.setCellValueFactory(new PropertyValueFactory<>("district"));
        districtColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        cityColumn.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        cityColumn.setCellFactory(ChoiceBoxTableCell.forTableColumn(cityChoiceBox.getItems()));

        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        postalCodeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        addressLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        addressTableView.getItems().addAll();
    }

    public void updateAddressTableView() {
        addressTableView.setItems(FXCollections.observableList(addressDAO.read()));
        addressTableView.getItems().addAll();
    }


    public void updateCityBox() {
        cityChoiceBox.setItems(FXCollections.observableList(cityDAO.read()));
    }


    public void createAddress() {
        if (addressTextField != null && cityChoiceBox != null) {
            Address address = new Address(addressTextField.getText(),
                    districtTextField.getText(),
                    cityChoiceBox.getSelectionModel().getSelectedItem(),
                    postalCodeTextField.getText(),
                    phoneTextField.getText());
            addressDAO.create(address);
            updateAddressTableView();
            addressTextField.setText("");
            districtTextField.setText("");
            postalCodeTextField.setText("");
            phoneTextField.setText("");
        }
    }

    public void deleteAddress() {
        Address address = addressTableView.getSelectionModel().getSelectedItem();
        addressDAO.delete(address);
        updateAddressTableView();
    }

    public void editAddress(TableColumn.CellEditEvent<Customer, String> addressStringCellEditEvent) {
        addressTableView.getSelectionModel().getSelectedItem().setAddress(addressStringCellEditEvent.getNewValue());
        addressTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        addressDAO.update(addressTableView.getSelectionModel().getSelectedItem());
        updateAddressTableView();
    }

    public void editDistrict(TableColumn.CellEditEvent<Customer, String> addressStringCellEditEvent) {
        addressTableView.getSelectionModel().getSelectedItem().setDistrict(addressStringCellEditEvent.getNewValue());
        addressTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        addressDAO.update(addressTableView.getSelectionModel().getSelectedItem());
        updateAddressTableView();
    }

    public void editCity(TableColumn.CellEditEvent<Customer, City> addressCityCellEditEvent) {
        addressTableView.getSelectionModel().getSelectedItem().setCityId(addressCityCellEditEvent.getNewValue());
        addressTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        addressDAO.update(addressTableView.getSelectionModel().getSelectedItem());
        updateAddressTableView();
    }

    public void editPostalCode(TableColumn.CellEditEvent<Customer, String> addressStringCellEditEvent) {
        addressTableView.getSelectionModel().getSelectedItem().setPostalCode(addressStringCellEditEvent.getNewValue());
        addressTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        addressDAO.update(addressTableView.getSelectionModel().getSelectedItem());
        updateAddressTableView();
    }

    public void editPhone(TableColumn.CellEditEvent<Customer, String> addressLongCellEditEvent) {
        addressTableView.getSelectionModel().getSelectedItem().setPhone(addressLongCellEditEvent.getNewValue());
        addressTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
        addressDAO.update(addressTableView.getSelectionModel().getSelectedItem());
        updateAddressTableView();
    }


}


























