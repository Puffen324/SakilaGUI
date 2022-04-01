package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.AddressDAO;
import com.yaelev.sakilagui.dao.LanguageDAO;
import com.yaelev.sakilagui.entity.Language;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class LanguageTabController implements Initializable {
    @FXML
    private TableView<Language> languageTableView;
    @FXML
    private TableColumn<Language, Integer> launguageIdColumn;
    @FXML
    private TableColumn<Language,String> langColumn;
    @FXML
    private TableColumn<Language, Timestamp> lastUpdateColumn;

    public void updatelanguageTableView(){
            languageTableView.setItems(FXCollections.observableList(new LanguageDAO().read()));
            launguageIdColumn.setCellValueFactory(new PropertyValueFactory<>("languageId"));
            langColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
            languageTableView.getItems().addAll();


     }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updatelanguageTableView();
    }

}
