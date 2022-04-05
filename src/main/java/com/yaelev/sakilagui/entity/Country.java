package com.yaelev.sakilagui.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id")
    private int countryId;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "country")
    private List<City> cityList;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Country(int countryId, String country, Timestamp lastUpdate) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public Country() {
    }

    @Override
    public String toString() {
        return country;
    }
}
