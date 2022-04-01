package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.AddressDAO;
import com.yaelev.sakilagui.dao.CityDAO;
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
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;

public class AddressTabContoller  implements Initializable {
    @FXML
    private TableView<Address> addressEntityTableView;
    @FXML
    private TableColumn<Address, Integer> addressIdColumn;
    @FXML
    private TableColumn<Address, String> addressNameColumn;
    @FXML
    private TableColumn<Address, String> districtColumn;
    @FXML
    private TableColumn<Address, Integer> city_idColumn;
    @FXML
    private TableColumn<Address, Integer> postalCodeColumn1;
    @FXML
    private TableColumn<Address, Integer> phoneColumn11;
    @FXML
    private TableColumn<Address, Integer> locationColumn111;
    @FXML
    private TableColumn<Address, Timestamp> addressLastUpdateColumn1111;
    @FXML
    private ComboBox<City> cityComboBox;
    @FXML
    private TextField addressTextField ,districtTextfield,phoneTextfield,postalCodeTextfield,locationTextfield;

    public void updateAddressEntityTableView(){
        addressEntityTableView.setItems(FXCollections.observableList(new AddressDAO().read()));
        addressIdColumn.setCellValueFactory(new PropertyValueFactory<>("addressId"));
        addressNameColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        districtColumn.setCellValueFactory(new PropertyValueFactory<>("district"));
        city_idColumn.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        postalCodeColumn1.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        phoneColumn11.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        locationColumn111.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        addressLastUpdateColumn1111.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        addressEntityTableView.getItems().addAll();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateAddressEntityTableView();
        updateCityBox();
    }
    public void updateCityBox(){
        cityComboBox.setItems(FXCollections.observableList(new CityDAO().read()));
        cityComboBox.getItems().addAll();
    }
    public void createAddress(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String nowTime = simpleDateFormat.format(date);
        Timestamp dates = Timestamp.valueOf(nowTime);


        if(addressTextField !=null && cityComboBox !=null){
            Address address = new Address(addressTextField.getText(),
                    districtTextfield.getText(),
                    cityComboBox.getSelectionModel().getSelectedItem().getCityId(),
                    postalCodeTextfield.getText(),
                    phoneTextfield.getText());
            new AddressDAO().create(address);
            updateAddressEntityTableView();
            addressTextField.setText("");
            districtTextfield.setText("");
            cityComboBox.setItems(null);
            postalCodeTextfield.setText("");
            phoneTextfield.setText("");
        }
    }
    public void deleteAddress(){

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
    public void updateLastUpdate(){
        LocalDateTime dateTime = LocalDateTime.now();
    }
}


























