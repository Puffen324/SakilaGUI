package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.entity.LanguageEntity;
import com.yaelev.sakilagui.entity.StaffEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class LanguageTabController implements Initializable {
    @FXML
    private TableView<LanguageEntity> languageEntityTableView;
    @FXML
    private TableColumn<LanguageEntity, Integer> langColumn;
    @FXML
    private TableColumn<LanguageEntity, Timestamp> lastUpdateColumn;

    public void updateStaffEntityTableView(){
        //Backended ÄR inte klart ännu

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //updateStaffEntityTableView();
    }
    public void updateLanguage(){

    }
    public void updateLastUpdate(){

    }
}
