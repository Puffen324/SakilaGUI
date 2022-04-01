package com.yaelev.sakilagui.controllers;


import com.yaelev.sakilagui.dao.StoreDAO;
import com.yaelev.sakilagui.entity.Store;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TableColumn<Store, Integer> managerStaffIdColumn1;
    @FXML
    private TableColumn<Store, Integer> addressIdColumn;
    @FXML
    private TableColumn<Store, Timestamp> latestUpdateColumn111;



    public void updateStoreEntityTableView(){
        //try{
            storeTableView.setItems(FXCollections.observableList(new StoreDAO().read()));
            storeIdColumn.setCellValueFactory(new PropertyValueFactory<>("storeId"));
            managerStaffIdColumn1.setCellValueFactory(new PropertyValueFactory<>("managerStaffId"));
            addressIdColumn.setCellValueFactory(new PropertyValueFactory<>("addressId"));
            latestUpdateColumn111.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
            storeTableView.getItems().addAll();
        /*}catch(Exception e){
            System.out.println(e);
        }*/


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateStoreEntityTableView();
    }
    public void managerStaffIdUpdate(){}
    public void addressIdUpdate(){}
    public void latestUpdate(){}
}
