package com.yaelev.sakilagui.controllers;

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

    private LanguageDAO languageDAO = new LanguageDAO();
    @FXML
    private TableView<Language> languageTableView;
    @FXML
    private TableColumn<Language, Integer> languageColumn;
    @FXML
    private TableColumn<Language,String> langColumn;
    @FXML
    private TableColumn<Language, Timestamp> lastUpdateColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateLanguageTableView();
    }

    public void updateLanguageTableView(){
            languageTableView.setItems(FXCollections.observableList(languageDAO.read()));
            languageColumn.setCellValueFactory(new PropertyValueFactory<>("languageId"));
            langColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
            languageTableView.getItems().addAll();
     }
}
