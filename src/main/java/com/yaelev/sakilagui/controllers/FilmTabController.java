package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.FilmDAO;
import com.yaelev.sakilagui.dao.RentalDAO;
import com.yaelev.sakilagui.entity.Film;
import com.yaelev.sakilagui.entity.Rental;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class FilmTabController implements Initializable {
    @FXML
    private TableView<Film> filmTableView;
    @FXML
    private TableColumn<Film,Integer> filmIdColumn;
    @FXML
    private TableColumn<Film,String> titleColumn;
    @FXML
    private TableColumn<Film,String> descriptionColumn;
    @FXML
    private TableColumn<Film,String> languageColumn;
    @FXML
    private TableColumn<Film,Integer>releaseYearColumn;
    @FXML
    private TableColumn<Film,Integer> playTimeColumn;
    @FXML
    private TableColumn<Film,String> ratingColumn;
    @FXML
    private TableColumn<Film, Timestamp> lastUpdateColumn;
    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateFilmTableView();
        updateRentalDetailstTableView();
    }
    public void updateFilmTableView(){
        filmTableView.setItems(FXCollections.observableList(new FilmDAO().read()));
        filmIdColumn.setCellValueFactory(new PropertyValueFactory<>("filmId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("languageId"));
        releaseYearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        playTimeColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        lastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        filmTableView.getItems().addAll();
    }
    @FXML
    private TableView<Rental> rentalDetailsTableViews;
    @FXML
    private TableColumn<Rental,Integer> filmidRentDetailsColumn;
    @FXML
    private TableColumn<Rental,Timestamp> rentalPeriodColumn;
    @FXML
    private TableColumn<Rental,Float> rentalCostColumn;
    @FXML
    private TableColumn<Rental,Integer> lenghtColumn;
    @FXML
    private TableColumn<Rental,Timestamp> rentalLastUpdateColumn;
    public void updateRentalDetailstTableView(){
        rentalDetailsTableViews.setItems(FXCollections.observableList(new RentalDAO().read()));
        filmidRentDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
        rentalPeriodColumn.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
        //rentalCostColumn.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
        rentalLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        rentalDetailsTableViews.getItems().addAll();
    }
}
