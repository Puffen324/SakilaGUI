package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.FilmDAO;
import com.yaelev.sakilagui.dao.InventoryDAO;
import com.yaelev.sakilagui.entity.Film;
import com.yaelev.sakilagui.entity.Inventory;
import com.yaelev.sakilagui.entity.Store;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
    private TableColumn<Inventory, Store> storeColumn;
    @FXML
    private ComboBox<Film> filmComboBox;
    @FXML
    private TableColumn<Inventory, Timestamp> latestUpdateColumn;

    public void updateInventoryTableView(){
        inventoryTableView.setItems(FXCollections.observableList(new InventoryDAO().read()));
        inventoryIdColumn.setCellValueFactory(new PropertyValueFactory<>("inventoryId"));
        filmIdColumn.setCellValueFactory(new PropertyValueFactory<>("filmId"));
        storeColumn.setCellValueFactory(new PropertyValueFactory<>("store"));
        latestUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        inventoryTableView.getItems().addAll();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateInventoryTableView();
        updateFilmComboBox();
    }
    

    public void updateFilmComboBox(){
        filmComboBox.setItems(FXCollections.observableList(new FilmDAO().read()));
        filmComboBox.getItems().addAll();
    }
}
