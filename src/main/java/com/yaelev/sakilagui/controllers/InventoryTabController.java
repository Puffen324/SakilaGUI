package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.entity.Inventory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class InventoryTabController implements Initializable {
    @FXML
    private TableView<Inventory> inventoryTableView;

    @FXML
    private TableColumn<Inventory, Integer> inventoryIdColumn;
    @FXML
    private TableColumn<Inventory,Integer> filmIdColumn;
    @FXML
    private TableColumn<Inventory,Integer> storeIdColumn;
    @FXML
    private TableColumn<Inventory, Timestamp> latestUpdateColumn;

    public void updateInventoryTableView(){
        //Backended ÄR inte klart ännu

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void filmIdUpdate(){}
    public void storeIdUpdate(){}
    public void latestUpdate(){}
}
