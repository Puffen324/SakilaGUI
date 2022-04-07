package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.FilmDAO;
import com.yaelev.sakilagui.dao.InventoryDAO;
import com.yaelev.sakilagui.dao.StoreDAO;
import com.yaelev.sakilagui.entity.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ResourceBundle;

public class InventoryTabController implements Initializable {

    private InventoryDAO inventoryDAO = new InventoryDAO();
    private FilmDAO filmDAO = new FilmDAO();
    private StoreDAO storeDAO = new StoreDAO();

    @FXML
    private TableView<Inventory> inventoryTableView;
    @FXML
    private TableColumn<Inventory, Integer> inventoryIdColumn;
    @FXML
    private TableColumn<Inventory, Integer> filmIdColumn;
    @FXML
    private TableColumn<Inventory, Store> storeColumn;
    @FXML
    private ComboBox<Film> filmComboBox;
    @FXML
    private TableColumn<Inventory, Timestamp> lastUpdateColumn;
    @FXML
    private ComboBox<Store> storeCombobox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupTableView();
        updateFilmComboBox();
        updateStoreComboBox();
    }

    public void setupTableView() {
        inventoryTableView.setItems(FXCollections.observableList(inventoryDAO.read()));
        inventoryIdColumn.setCellValueFactory(new PropertyValueFactory<>("inventoryId"));
        filmIdColumn.setCellValueFactory(new PropertyValueFactory<>("filmId"));
        storeColumn.setCellValueFactory(new PropertyValueFactory<>("store"));
        lastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        inventoryTableView.getItems().addAll();
    }

    public void updateInventoryTableView() {
        inventoryTableView.setItems(FXCollections.observableList(inventoryDAO.read()));
        inventoryTableView.getItems().addAll();
    }

    public void updateFilmComboBox() {
        filmComboBox.setItems(FXCollections.observableList(filmDAO.read()));
        filmComboBox.getItems().addAll();
    }

    public void updateStoreComboBox() {
        storeCombobox.setItems(FXCollections.observableList(storeDAO.read()));
        storeCombobox.getItems().addAll();
    }

    public void createInventory() {
        Inventory inventory = new Inventory();
        inventory.setFilmId(filmComboBox.getSelectionModel().getSelectedItem().getFilmId());
        inventory.setStore(storeCombobox.getSelectionModel().getSelectedItem());
        inventory.setLastUpdate(Timestamp.from(Instant.now()));
        inventoryDAO.create(inventory);
        updateInventoryTableView();
    }

    public void deleteInventory() {
        Inventory inventory = inventoryTableView.getSelectionModel().getSelectedItem();
        inventoryDAO.executeInsideTransaction(entityManager ->
                entityManager.createNativeQuery("DELETE FROM rental WHERE inventory_id = ? ")
                        .setParameter(1, inventory.getInventoryId())
                        .executeUpdate());
        inventoryDAO.delete((inventory));
        updateInventoryTableView();
    }
}
