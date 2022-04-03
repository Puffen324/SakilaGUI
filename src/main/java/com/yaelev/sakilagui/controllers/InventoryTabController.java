package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.ActorDAO;
import com.yaelev.sakilagui.dao.InventoryDAO;
import com.yaelev.sakilagui.entity.Inventory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        inventoryTableView.setItems(FXCollections.observableList(new InventoryDAO().read()));
        inventoryIdColumn.setCellValueFactory(new PropertyValueFactory<>("inventoryId"));
        //dessa 3 verkar inte fungera vet inte än varför det verkar ju som att de är som de andra
        //filmIdColumn.setCellValueFactory(new PropertyValueFactory<>("film_id"));
        //storeIdColumn.setCellValueFactory(new PropertyValueFactory<>("store_id"));
        //latestUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("last_update"));
        inventoryTableView.getItems().addAll();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateInventoryTableView();
    }
    public void filmIdUpdate(){}
    public void storeIdUpdate(){}
    public void latestUpdate(){}
}
