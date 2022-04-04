package com.yaelev.sakilagui.controllers;


import com.yaelev.sakilagui.dao.AddressDAO;
import com.yaelev.sakilagui.dao.StaffDAO;
import com.yaelev.sakilagui.dao.StoreDAO;
import com.yaelev.sakilagui.entity.Address;
import com.yaelev.sakilagui.entity.Staff;
import com.yaelev.sakilagui.entity.Store;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class StoreTabController implements Initializable {
    @FXML
    private TableView<Store> storeTableView;

    @FXML
    private TableColumn<Store, Integer> storeIdColumn;

    @FXML
    private TableColumn<Store, Staff> staffColumn;
    @FXML
    private TableColumn<Store, Address> addressColumn;
    @FXML
    private TableColumn<Store, Timestamp> latestUpdateColumn111;

    @FXML
    private ComboBox <Address> addressComboBox;
    @FXML
    private ComboBox <Staff> managerCombobox;
    @FXML
    private Button deleteStoreBtn,createStoreBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateStoreEntityTableView();
        updateAddressBox();
        updateManagerBox();
    }
    public void updateStoreEntityTableView(){

            storeTableView.setItems(FXCollections.observableList(new StoreDAO().read()));
            storeIdColumn.setCellValueFactory(new PropertyValueFactory<>("storeId"));
            staffColumn.setCellValueFactory(new PropertyValueFactory<>("staff"));
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
            latestUpdateColumn111.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
            storeTableView.getItems().addAll();


    }
    public void updateAddressBox(){
        addressComboBox.setItems((FXCollections.observableList(new AddressDAO().read())));
        addressComboBox.getItems().addAll();
    }
    public void updateManagerBox(){
        managerCombobox.setItems((FXCollections.observableList(new StaffDAO().read().stream().filter(staff -> !staff.isActive()).toList())));
        managerCombobox.getItems().addAll();

    }
    public void createStoreBtn(){}
    public void deleteBtn(){
        deleteStore();
    }
    public void createStore(){
        Store store = new Store(managerCombobox.getSelectionModel().getSelectedItem()
                ,addressComboBox.getSelectionModel().getSelectedItem());
        new StoreDAO().create(store);
        managerCombobox.getSelectionModel().getSelectedItem().setActive(true);
        updateManagerBox();
        updateStoreEntityTableView();
    }

    public void deleteStore(){
        Store store = storeTableView.getSelectionModel().getSelectedItem();
        new StoreDAO().delete(store);
        updateStoreEntityTableView();
    }
    public void managerStaffIdUpdate(){}
    public void addressIdUpdate(){}
    public void latestUpdate(){}
}
