package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.PaymentDAO;
import com.yaelev.sakilagui.entity.Actor;
import com.yaelev.sakilagui.entity.Payment;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BigDecimalStringConverter;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ResourceBundle;

public class PaymentTabController implements Initializable {

    @FXML
    private TableColumn<Payment, Integer> paymentCustomerIdColumn;

    @FXML
    private TableColumn<Payment, Timestamp> paymentDateColumn;

    @FXML
    private TableColumn<Payment, Integer> paymentIdColumn;

    @FXML
    private TableColumn<Payment, Timestamp> paymentLastUpdateColumn;

    @FXML
    private TableColumn<Payment, Integer> paymentRentalIdColumn;

    @FXML
    private TableColumn<Payment, Integer> paymentStaffIdColumn;

    @FXML
    private TableColumn<Payment, BigDecimal> paymentSumColumn;

    @FXML
    private TableView<Payment> paymentTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpTableView();

    }

    public void setUpTableView(){
        paymentTableView.setItems(FXCollections.observableList(new PaymentDAO().read()));
        paymentIdColumn.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        paymentCustomerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        paymentStaffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        paymentRentalIdColumn.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
        paymentSumColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentSumColumn.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        paymentLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        paymentTableView.getItems().addAll();
    }

    public void updatePaymentTableView() {
        paymentTableView.setItems(FXCollections.observableList(new PaymentDAO().read()));
        paymentTableView.getItems().addAll();
    }

    public void deletePayment() {
        Payment payment = paymentTableView.getSelectionModel().getSelectedItem();
        new PaymentDAO().delete(payment);
        updatePaymentTableView();
    }

    public void createPayment() {

    }

    public void editAmount(TableColumn.CellEditEvent<Payment, BigDecimal> paymentBigDecimalCellEditEvent) {
        if (paymentTableView.getSelectionModel().getSelectedItem() != null) {
            paymentTableView.getSelectionModel().getSelectedItem().setAmount(paymentBigDecimalCellEditEvent.getNewValue());
            paymentTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
            new PaymentDAO().update(paymentTableView.getSelectionModel().getSelectedItem());
            updatePaymentTableView();
        }
    }


}




