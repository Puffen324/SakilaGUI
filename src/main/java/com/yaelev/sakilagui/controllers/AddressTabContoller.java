package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.AddressDAO;
import com.yaelev.sakilagui.dao.CityDAO;
import com.yaelev.sakilagui.dao.PaymentDAO;
import com.yaelev.sakilagui.entity.Address;
import com.yaelev.sakilagui.entity.City;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class AddressTabContoller  implements Initializable {
    @FXML
    private TableView<Address> addressTableView;
    @FXML
    private TableColumn<Address, Integer> addressIdColumn;
    @FXML
    private TableColumn<Address, String> addressNameColumn;
    @FXML
    private TableColumn<Address, String> districtColumn;
    @FXML
    private TableColumn<Address, Integer> cityIdColumn;
    @FXML
    private TableColumn<Address, Integer> postalCodeColumn;
    @FXML
    private TableColumn<Address, Integer> phoneColumn;
    @FXML
    private TableColumn<Address, Timestamp> addressLastUpdateColumn;
    @FXML
    private ComboBox<City> cityComboBox;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField districtTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField postalCodeTextField;

    public void setUpAddressTableView(){
        addressTableView.setItems(FXCollections.observableList(new AddressDAO().read()));
        addressIdColumn.setCellValueFactory(new PropertyValueFactory<>("addressId"));
        addressNameColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        districtColumn.setCellValueFactory(new PropertyValueFactory<>("district"));
        cityIdColumn.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        addressTableView.getItems().addAll();
    }

    public void updateAddressTableView(){
        addressTableView.setItems(FXCollections.observableList(new AddressDAO().read()));
        addressTableView.getItems().addAll();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setUpAddressTableView();
        updateCityBox();
    }

    public void updateCityBox(){
        cityComboBox.setItems(FXCollections.observableList(new CityDAO().read()));
        cityComboBox.getItems().addAll();
    }

    // Avvaktar svar från Fredde/Tompa. Fokusera på annat tills vi vet mer.
    public void createAddress(){

        if(addressTextField != null && cityComboBox != null){
            Address address = new Address(addressTextField.getText(),
                    districtTextField.getText(),
                    cityComboBox.getSelectionModel().getSelectedItem().getCityId(),
                    postalCodeTextField.getText(),
                    phoneTextField.getText());
            new AddressDAO().create(address);
            updateAddressTableView();
            addressTextField.setText("");
            districtTextField.setText("");
            postalCodeTextField.setText("");
            phoneTextField.setText("");
        }
    }
    public void deleteAddress(){
        Address address = addressTableView.getSelectionModel().getSelectedItem();
        new AddressDAO().delete(address);
        updateAddressTableView();
    }
    public void updateAddress(){

    }
    public void updateDistrict(){

    }
    public void updateCity_id(){

    }
    public void updatePostalCode(){

    }
    public void updatePhone(){

    }
    public void updateLocation(){

    }

}


























