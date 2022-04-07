package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.ActorDAO;
import com.yaelev.sakilagui.dao.FilmDAO;
import com.yaelev.sakilagui.entity.Actor;
import com.yaelev.sakilagui.entity.Film;
import com.yaelev.sakilagui.entity.Language;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.ResourceBundle;

public class ActorTabController implements Initializable {


        @FXML
        private TableView<Actor> actorTableView;
        @FXML
        private TableColumn<Actor, String> actorFirstNameColumn;
        @FXML
        private TableColumn<Actor, Integer> actorIdColumn;
        @FXML
        private TableColumn<Actor, String> actorLastNameColumn;
        @FXML
        private TableColumn<Actor, Timestamp> actorLastUpdateColumn;
        @FXML
        private TextField actorFirstNameConstr;
        @FXML
        private TextField actorLastNameConstr;
        @FXML
        private Button deleteButton = new Button();

        @FXML
        private TableView<Film> actorFilmTableView;
        @FXML
        private TableColumn<Film, Integer> actorFilmIdColumn;
        @FXML
        private TableColumn<Film, String> actorFilmTitleColumn;
        @FXML
        private TableColumn<Film, Language> actorFilmLanguageColumn;
        @FXML
        private TableColumn<Film, Integer> actorFilmReleaseYearColumn;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                setupTableViews();
                bindings();
        }

        public void setupTableViews(){
                actorTableView.setItems(FXCollections.observableList(new ActorDAO().read()));
                actorIdColumn.setCellValueFactory(new PropertyValueFactory<>("actorId"));
                actorFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                actorFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                actorLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                actorLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                actorLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
                actorTableView.getItems().addAll();
        }
        public void updateActorFilmTableView(){
                if(actorTableView.getSelectionModel().getSelectedItem() != null){
                        actorFilmTableView.setItems(
                                FXCollections.observableArrayList(
                                        actorTableView.getSelectionModel().getSelectedItem()
                                                .getFilmList()));

                        if(actorTableView.getSelectionModel().getSelectedItem().getFilmList().isEmpty()){
                                deleteButton.setDisable(false);
                        }else
                                deleteButton.setDisable(true);
                }
                actorFilmIdColumn.setCellValueFactory(new PropertyValueFactory<>("filmId"));
                actorFilmTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
                actorFilmLanguageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
                actorFilmReleaseYearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        }

        public void updateActorTableView() {
                actorTableView.setItems(FXCollections.observableList(new ActorDAO().read()));
                actorTableView.getItems().addAll();
        }

        public void updateActorFirstName(TableColumn.CellEditEvent<Actor, String> actorStringCellEditEvent){
                actorTableView.getSelectionModel().getSelectedItem().setFirstName(actorStringCellEditEvent.getNewValue());
                actorTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
                new ActorDAO().update(actorTableView.getSelectionModel().getSelectedItem());
                updateActorTableView();
        }

        public void updateActorLastName(TableColumn.CellEditEvent<Actor, String> actorStringCellEditEvent){
                actorTableView.getSelectionModel().getSelectedItem().setLastName(actorStringCellEditEvent.getNewValue());
                actorTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
                new ActorDAO().update(actorTableView.getSelectionModel().getSelectedItem());
                updateActorTableView();
        }

        public void createActor(){
                if(actorFirstNameConstr != null && actorLastNameConstr != null){
                        Actor actor = new Actor(actorFirstNameConstr.getText(), actorLastNameConstr.getText());
                        new ActorDAO().create(actor);
                        updateActorTableView();
                        actorFirstNameConstr.setText("");
                        actorLastNameConstr.setText("");
                }
        }

        public void deleteActor(){
                Actor actor = actorTableView.getSelectionModel().getSelectedItem();
                new ActorDAO().delete(actor);
                updateActorTableView();
        }

        public void bindings(){

        }

        public void removeFilmFromActor(){
                if(actorTableView.getSelectionModel().getSelectedItem() != null &&
                actorFilmTableView.getSelectionModel().getSelectedItem() != null){
                        Actor actor = actorTableView.getSelectionModel().getSelectedItem();
                        actor.getFilmList().remove(actorFilmTableView.getSelectionModel().getSelectedItem());
                        Film film = actorFilmTableView.getSelectionModel().getSelectedItem();
                        film.getActorList().remove(actorTableView.getSelectionModel().getSelectedItem());
                        new FilmDAO().update(film);
                        updateActorFilmTableView();
                }
        }
}
