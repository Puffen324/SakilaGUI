package com.yaelev.sakilagui.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inventory_id")
    private int inventoryId;
    @Basic
    @Column(name = "film_id")
    private int filmId;

    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY,cascade= CascadeType.REMOVE)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "inventory")
    private List<Rental> rentalList;

    @Transient
    private Film film;

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public Inventory() {
    }

    public Inventory(int inventoryId, int filmId, Store store, Timestamp lastUpdate) {
        this.inventoryId = inventoryId;
        this.filmId = filmId;
        this.store = store;
        this.lastUpdate = lastUpdate;
    }
    public String getFilm(){return film.toString();}

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    @Override
    public String toString() {
        return
                inventoryId+"";


    }
}
