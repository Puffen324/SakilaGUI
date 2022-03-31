package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.ActorDAO;
import com.yaelev.sakilagui.entity.Actor;
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


        public void updateActorEntityTableView(){
                actorTableView.setItems(FXCollections.observableList(new ActorDAO().read()));
                actorIdColumn.setCellValueFactory(new PropertyValueFactory<>("actorId"));
                actorFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                actorFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                actorLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                actorLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                actorLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
                actorTableView.getItems().addAll();
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                updateActorEntityTableView();
        }

        public void updateActorFirstName(TableColumn.CellEditEvent<Actor, String> actorStringCellEditEvent){
                actorTableView.getSelectionModel().getSelectedItem().setFirstName(actorStringCellEditEvent.getNewValue());
                new ActorDAO().update(actorTableView.getSelectionModel().getSelectedItem());
                updateActorEntityTableView();
        }
        public void updateActorLastName(TableColumn.CellEditEvent<Actor, String> actorStringCellEditEvent){
                actorTableView.getSelectionModel().getSelectedItem().setLastName(actorStringCellEditEvent.getNewValue());
                new ActorDAO().update(actorTableView.getSelectionModel().getSelectedItem());
                updateActorEntityTableView();
        }
        public void createActor(){
                if(actorFirstNameConstr != null && actorLastNameConstr != null){
                        Actor actor = new Actor(actorFirstNameConstr.getText(), actorLastNameConstr.getText());
                        new ActorDAO().create(actor);
                        updateActorEntityTableView();
                        actorFirstNameConstr.setText("");
                        actorLastNameConstr.setText("");
                }

        }
        public void deleteActor(){
                Actor actor = actorTableView.getSelectionModel().getSelectedItem();
                new ActorDAO().delete(actor);
                updateActorEntityTableView();
        }

}



