package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.ActorDAO;
import com.yaelev.sakilagui.entity.Actor;
import com.yaelev.sakilagui.entity.Film;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
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

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                updateActorTableView();
        }

        public void updateActorTableView(){
                actorTableView.setItems(FXCollections.observableList(new ActorDAO().read()));
                actorIdColumn.setCellValueFactory(new PropertyValueFactory<>("actorId"));
                actorFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                actorFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                actorLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                actorLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                actorLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
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


        @FXML
        private TableView<Film> actorFilmTableView;

        @FXML
        private TableColumn<Film, Integer> filmActorIdColumn;

        @FXML
        private TableColumn<Film, Integer> actorFilmIdColumn;

        @FXML
        private TableColumn<Film, Timestamp> actorFilmLastUpdateColumn;

        //.stream().filter(actor -> actor.getActorId() < 50).toList())

        public void updateActorFilmTableView(){

        }
}



