
package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.ActorDAO;
import com.yaelev.sakilagui.dao.FilmDAO;
import com.yaelev.sakilagui.dao.LanguageDAO;
import com.yaelev.sakilagui.entity.Actor;
import com.yaelev.sakilagui.entity.Film;
import com.yaelev.sakilagui.entity.Language;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class FilmCreationController implements Initializable {

    private Film film;
    private List<String> ratingList = Arrays.asList("PG", "G", "NC-17", "PG-13", "R");
    private List<String> specialFeatureList = Arrays.asList("Trailers", "Behind the Scenes", "Commentaries", "Deleted Scenes");


    @FXML
    private TableView<Actor> filmCreationTableView;

    @FXML
    private TableColumn<Actor, CheckBox> checkBoxColumn;

    @FXML
    private TableColumn<Actor, Integer> actorIdColumn;

    @FXML
    private TableColumn<Actor, String> actorFirstNameColumn;

    @FXML
    private TableColumn<Actor, String> actorLastNameColumn;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ChoiceBox<Language> languageChoiceBox;

    @FXML
    private ChoiceBox<String> ratingChoiceBox;

    @FXML
    private ChoiceBox<String> specialFeatureChoiceBox;

    @FXML
    private Spinner<Integer> lengthSpinner;

    @FXML
    private Spinner<Integer> releaseYearSpinner;

    @FXML
    private Spinner<Double> rentalCostSpinner;

    @FXML
    private Spinner<Integer> rentalPeriodSpinner;

    @FXML
    private Spinner<Double> replacementCostSpinner;

    @FXML
    private TextField titleTextField;

    @FXML
    private Button createButton = new Button();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        film = new Film();
        List<Actor> actorList = new ActorDAO().read();
        setupTableView(FXCollections.observableArrayList(actorList));
        setupChoiceBoxes();
        setupSpinners();
        bindings();

    }

    public void createNewFilm() {
        setTitle();
        setLanguage();
        setRating();
        setSpecialFeature();
        setReleaseYear();
        setRentalCost();
        setReplacementCost();
        setRentalPeriod();
        setLength();
        setDescription();
        setActors(filmCreationTableView.getItems());
        new FilmDAO().create(film);
        film = new Film();
        titleTextField.setText("");
        descriptionTextArea.setText("");
        languageChoiceBox.setValue(null);
        ratingChoiceBox.setValue(null);
        specialFeatureChoiceBox.setValue(null);
    }

    public void bindings() {
        BooleanBinding titleTextFieldValid = Bindings.createBooleanBinding(() -> {
            if (titleTextField.getText().length() > 0) {
                return true;
            } else {
                return false;
            }

        }, titleTextField.textProperty());

        BooleanBinding languageChoiceBoxValid = Bindings.createBooleanBinding(() -> {
            if (languageChoiceBox.getSelectionModel().getSelectedItem() != null) {
                return true;
            } else {
                return false;
            }

        }, languageChoiceBox.valueProperty());

        BooleanBinding ratingChoiceBoxValid = Bindings.createBooleanBinding(() -> {
            if (ratingChoiceBox.getSelectionModel().getSelectedItem() != null) {
                return true;
            } else {
                return false;
            }

        }, ratingChoiceBox.valueProperty());

        BooleanBinding specialFeatureChoiceBoxValid = Bindings.createBooleanBinding(() -> {
            if (specialFeatureChoiceBox.getSelectionModel().getSelectedItem() != null) {
                return true;
            } else {
                return false;
            }

        }, specialFeatureChoiceBox.valueProperty());

        createButton.disableProperty().bind(
                         titleTextFieldValid.not()
                        .or(languageChoiceBoxValid.not())
                        .or(ratingChoiceBoxValid.not())
                        .or(specialFeatureChoiceBoxValid.not()));
    }

    public void setupTableView(ObservableList<Actor> actorList) {
        filmCreationTableView.setItems(actorList);
        checkBoxColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Actor, CheckBox>, ObservableValue<CheckBox>>() {
            @Override
            public ObservableValue<CheckBox> call(
                    TableColumn.CellDataFeatures<Actor, CheckBox> actorCheckBoxCellDataFeatures) {
                Actor actor = actorCheckBoxCellDataFeatures.getValue();

                CheckBox checkBox = new CheckBox();
                checkBox.selectedProperty().setValue(actor.getParticipating());

                checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                        actor.setParticipating(newValue);

                    }
                });
                return new SimpleObjectProperty<CheckBox>(checkBox);
            }
        });
        actorIdColumn.setCellValueFactory(new PropertyValueFactory<>("actorId"));
        actorFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        actorLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    }

    public void setupChoiceBoxes() {
        languageChoiceBox.setItems(FXCollections.observableArrayList(new LanguageDAO().read()));
        ratingChoiceBox.setItems(FXCollections.observableArrayList(ratingList));
        specialFeatureChoiceBox.setItems(FXCollections.observableArrayList(specialFeatureList));
    }

    public void setupSpinners() {
        releaseYearSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1950, 2022, 2000));
        releaseYearSpinner.setEditable(true);
        rentalCostSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.99, 4.99, 2.5));
        rentalCostSpinner.setEditable(true);
        replacementCostSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(9.99, 29.99, 15.0));
        replacementCostSpinner.setEditable(true);
        rentalPeriodSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(3, 7, 5));
        rentalPeriodSpinner.setEditable(true);
        lengthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(45, 190, 100));
        lengthSpinner.setEditable(true);

    }

    public void setTitle() {
        film.setTitle(titleTextField.getText());
    }

    public void setLanguage() {
        film.setLanguage(languageChoiceBox.getSelectionModel().getSelectedItem());
    }

    public void setRating() {
        film.setRating(ratingChoiceBox.getValue());
    }

    public void setSpecialFeature() {
        film.setSpecialFeatures(specialFeatureChoiceBox.getValue());
    }

    public void setReleaseYear() {
        film.setReleaseYear(releaseYearSpinner.getValue());
    }

    public void setRentalCost() {
        film.setRentalRate(BigDecimal.valueOf(rentalCostSpinner.getValue()));
    }

    public void setReplacementCost() {
        film.setReplacementCost(BigDecimal.valueOf(replacementCostSpinner.getValue()));
    }

    public void setRentalPeriod() {
        film.setRentalDuration(rentalPeriodSpinner.getValue());
    }

    public void setLength() {
        film.setLength(lengthSpinner.getValue());
    }

    public void setDescription() {
        film.setDescription(descriptionTextArea.getText());
    }

    public void setActors(List<Actor> actorList){
        for(Actor a : actorList){
            if(a.getParticipating() == true){
                film.getActorList().add(a);
            }
        }

    }

}





