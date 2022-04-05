package com.yaelev.sakilagui.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private int storeId;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_staff_id")
    private Staff staff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
    private List<Inventory> inventoryList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
    private List<Staff> staffList;



    public Store() {

    }

    public Store(Staff staff, Address address) {
        this.staff = staff;
        this.address = address;
        this.lastUpdate = Timestamp.from(Instant.now());
    }



    @Override
    public String toString() {
        return storeId + "";
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff managerStaffId) {
        this.staff = managerStaffId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
