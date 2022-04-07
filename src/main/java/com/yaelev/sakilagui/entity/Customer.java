package com.yaelev.sakilagui.entity;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "active")
    private Boolean active;
    @Basic
    @Column(name = "create_date")
    private Timestamp createDate;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Payment> payments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Rental> rentals;


    public Customer() {

    }

    public Customer(int customerId, Store store, String firstName, String lastName, String email, Address address, Boolean active, Timestamp createDate, Timestamp lastUpdate) {
        this.customerId = customerId;
        this.store = store;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.active = active;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
    }

    public Customer(String firstName, String lastName, String email, Address address, Store store, Boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.active = active;
        this.store = store;
    }


    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public ObservableValue<Boolean> getObsBoolean() {
        ObservableValue<Boolean> obsBoolean = new SimpleBooleanProperty(this.active).asObject();
        return obsBoolean;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return customerId + " " + firstName + " " + lastName;
    }
}
