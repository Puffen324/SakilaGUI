package com.yaelev.sakilagui.controllers;

import com.yaelev.sakilagui.dao.CustomerDAO;
import com.yaelev.sakilagui.dao.PaymentDAO;
import com.yaelev.sakilagui.dao.StaffDAO;
import com.yaelev.sakilagui.entity.Customer;
import com.yaelev.sakilagui.entity.Payment;
import com.yaelev.sakilagui.entity.Staff;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BigDecimalStringConverter;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ResourceBundle;

public class PaymentTabController implements Initializable {

    private PaymentDAO paymentDAO = new PaymentDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private StaffDAO staffDAO = new StaffDAO();
    @FXML
    private TableView<Payment> paymentTableView;
    @FXML
    private TableColumn<Payment, Customer> paymentCustomerColumn;
    @FXML
    private TableColumn<Payment, Timestamp> paymentDateColumn;
    @FXML
    private TableColumn<Payment, Integer> paymentIdColumn;
    @FXML
    private TableColumn<Payment, Timestamp> paymentLastUpdateColumn;
    @FXML
    private TableColumn<Payment, Integer> paymentRentalIdColumn;
    @FXML
    private TableColumn<Payment, Staff> paymentStaffColumn;
    @FXML
    private TableColumn<Payment, BigDecimal> paymentSumColumn;
    @FXML
    private ChoiceBox<Customer> customerChoiceBox;
    @FXML
    private ChoiceBox<Staff> staffChoiceBox;
    @FXML
    private TextField amountTextField;
    @FXML
    private Label ExceptionLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCustomerChoiceBox();
        updateStaffChoiceBox();
        setUpTableView();

    }

    public void setUpTableView() {
        paymentTableView.setItems(FXCollections.observableList(paymentDAO.read()));
        paymentIdColumn.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        paymentCustomerColumn.setCellValueFactory(new PropertyValueFactory<>("customer"));
        paymentStaffColumn.setCellValueFactory(new PropertyValueFactory<>("staff"));
        paymentRentalIdColumn.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
        paymentSumColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentSumColumn.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        paymentLastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        paymentTableView.getItems().addAll();
    }

    public void updatePaymentTableView() {
        paymentTableView.setItems(FXCollections.observableList(paymentDAO.read()));
        paymentTableView.getItems().addAll();
    }

    public void deletePayment() {
        Payment payment = paymentTableView.getSelectionModel().getSelectedItem();
        paymentDAO.delete(payment);
        updatePaymentTableView();
    }

    public void createPayment() {
        ExceptionLabel.setText("");
        if (customerChoiceBox.getSelectionModel().getSelectedItem() != null &&
                staffChoiceBox.getSelectionModel().getSelectedItem() != null &&
                amountTextField.getText().length() > 0) {
            try {
                Payment payment = new Payment(BigDecimal.valueOf(Long.parseLong(amountTextField.getText())), customerChoiceBox.getSelectionModel().getSelectedItem(),
                        staffChoiceBox.getSelectionModel().getSelectedItem());
                paymentDAO.create(payment);
            } catch (Exception e) {
                e.printStackTrace();
                ExceptionLabel.setText("Felaktig inmatning!");
            }
            updatePaymentTableView();
            amountTextField.setText("");
        }
    }

    public void editAmount(TableColumn.CellEditEvent<Payment, BigDecimal> paymentBigDecimalCellEditEvent) {
        if (paymentTableView.getSelectionModel().getSelectedItem() != null) {
            paymentTableView.getSelectionModel().getSelectedItem().setAmount(paymentBigDecimalCellEditEvent.getNewValue());
            paymentTableView.getSelectionModel().getSelectedItem().setLastUpdate(Timestamp.from(Instant.now()));
            paymentDAO.update(paymentTableView.getSelectionModel().getSelectedItem());
            updatePaymentTableView();
        }
    }

    public void updateCustomerChoiceBox() {
        customerChoiceBox.setItems(FXCollections.observableArrayList(customerDAO.read()));
    }

    public void updateStaffChoiceBox() {
        staffChoiceBox.setItems(FXCollections.observableArrayList(staffDAO.read()));
    }

}




