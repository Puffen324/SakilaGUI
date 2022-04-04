package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.CustomerDAO;
import com.yaelev.sakilagui.entity.Customer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class CustomerTabController implements Initializable {
    @FXML
    private TableView<Customer> customerTableViews;
    @FXML
    private TableColumn<Customer,Integer> customerIdColumn;
    @FXML
    private TableColumn<Customer,Integer> storeIdColumn;
    @FXML
    private TableColumn<Customer,String> customerForNameColumnn;
    @FXML
    private TableColumn<Customer, Timestamp> lastupdateColumn;
    @FXML
    private TableColumn<Customer,String> customerLastNameColumn;
    @FXML
    private TableColumn<Customer,String> emailColumn;
    @FXML
    private TableColumn<Customer,Integer> addressIdColumn;
    @FXML
    private TableColumn<Customer,Boolean> activColumn;
    @FXML
    private TableColumn<Customer,Timestamp> creatDateColumn;
    
    public void updateCustomerTable(){
        customerTableViews.setItems(FXCollections.observableList(new CustomerDAO().read()));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        storeIdColumn.setCellValueFactory(new PropertyValueFactory<>("storeId"));
        customerForNameColumnn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        customerLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        addressIdColumn.setCellValueFactory(new PropertyValueFactory<>("addressId"));
        activColumn.setCellValueFactory(new PropertyValueFactory<>("active"));
        creatDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        lastupdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        customerTableViews.getItems().addAll();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCustomerTable();
    }
}
