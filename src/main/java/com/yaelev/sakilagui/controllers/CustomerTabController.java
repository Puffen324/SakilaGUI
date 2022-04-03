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





    public void updateCustomerTable(){
        customerTableViews.setItems(FXCollections.observableList(new CustomerDAO().read()));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("KundID"));
        storeIdColumn.setCellValueFactory(new PropertyValueFactory<>("ButikID"));
        //actorFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        customerForNameColumnn.setCellValueFactory(new PropertyValueFactory<>("Fornamn"));
        //actorLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastupdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        customerTableViews.getItems().addAll();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCustomerTable();
    }
}
