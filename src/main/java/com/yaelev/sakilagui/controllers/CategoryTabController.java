package com.yaelev.sakilagui.controllers;


import com.yaelev.sakilagui.dao.CategoryDAO;
import com.yaelev.sakilagui.dao.FilmDAO;
import com.yaelev.sakilagui.entity.Category;
import com.yaelev.sakilagui.entity.Film;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class CategoryTabController  implements Initializable {
        @FXML
        private TableView<Category> categoryEntityTableView;

        @FXML
        private TableColumn<Category, Integer> categoryIdColumn;

        @FXML
        private TableColumn<Category, String> categoryNameColumn;


        @FXML
        private TableColumn<Category, Timestamp> categoryLastUpdateColumn;
        @FXML
        private TableView<Film> filmCategoryTable;
        @FXML
        private TableColumn<Film,Integer> filmIdColumn;
        @FXML
        private TableColumn<Film,String> filmTitleColumn;

        public void updateCategoryEntityTableView(){
                categoryEntityTableView.setItems(FXCollections.observableList(new CategoryDAO().read()));
                categoryIdColumn.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
                categoryNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
                categoryLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
                categoryEntityTableView.getItems();
            //Backended ÄR inte klart ännu

        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            updateCategoryEntityTableView();
        }
        public void updateName(){

        }

        public void updateLastUpdate(){

        }
        public void updateCategoryFilmTable(){
           if (categoryEntityTableView.getSelectionModel().getSelectedItem() != null) {
                   filmCategoryTable.setItems(FXCollections.observableArrayList(categoryEntityTableView.getSelectionModel().getSelectedItem().getFilmList()));
                   filmIdColumn.setCellValueFactory(new PropertyValueFactory<>("filmId"));
                   filmTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
                   categoryEntityTableView.getItems().addAll();
           }
        }
    }


