package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.ActorDAO;
import com.yaelev.sakilagui.dao.DataEntityManger;
import com.yaelev.sakilagui.entity.ActorEntity;
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
        private TableView<ActorEntity> actorTableView;

        @FXML
        private TableColumn<ActorEntity, String> actorFirstNameColumn;

        @FXML
        private TableColumn<ActorEntity, Integer> actorIdColumn;

        @FXML
        private TableColumn<ActorEntity, String> actorLastNameColumn;

        @FXML
        private TableColumn<ActorEntity, Timestamp> actorLastUpdateColumn;
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

        public void updateActorFirstName(TableColumn.CellEditEvent<ActorEntity, String> actorStringCellEditEvent){
                actorTableView.getSelectionModel().getSelectedItem().setFirstName(actorStringCellEditEvent.getNewValue());
                new ActorDAO().update(actorTableView.getSelectionModel().getSelectedItem());
                updateActorEntityTableView();
        }
        public void updateActorLastName(TableColumn.CellEditEvent<ActorEntity, String> actorStringCellEditEvent){
                actorTableView.getSelectionModel().getSelectedItem().setLastName(actorStringCellEditEvent.getNewValue());
                new ActorDAO().update(actorTableView.getSelectionModel().getSelectedItem());
                updateActorEntityTableView();
        }
        public void createActor(){
                if(actorFirstNameConstr != null && actorLastNameConstr != null){
                        ActorEntity actorEntity = new ActorEntity(actorFirstNameConstr.getText(), actorLastNameConstr.getText());
                        new ActorDAO().create(actorEntity);
                        updateActorEntityTableView();
                        actorFirstNameConstr.setText("");
                        actorLastNameConstr.setText("");
                }

        }
        public void deleteActor(){
                ActorEntity actorEntity = actorTableView.getSelectionModel().getSelectedItem();
                new ActorDAO().delete(actorEntity);
                updateActorEntityTableView();
        }
}



