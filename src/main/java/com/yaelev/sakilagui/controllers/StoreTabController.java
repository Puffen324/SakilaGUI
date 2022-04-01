package com.yaelev.sakilagui.controllers;


import com.yaelev.sakilagui.entity.Store;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
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

    public void updateStaffEntityTableView(){
        //Backended ÄR inte klart ännu

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //updateStaffEntityTableView();
    }
    public void managerStaffIdUpdate(){}
    public void addressIdUpdate(){}
    public void latestUpdate(){}
}
