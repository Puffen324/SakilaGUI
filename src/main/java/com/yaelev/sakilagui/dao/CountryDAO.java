package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Country;

import java.util.List;

public class CountryDAO extends GenericDAO<Country> {

    public CountryDAO() {
        super();
    }

    public void create(Country country) {
        executeInsideTransaction(entityManager -> entityManager.persist(country));

    }

    public List<City> read() {
        return entityManager.createNativeQuery("SELECT * FROM Country", Country.class).getResultList();
    }


    public void update(Country country) {
        executeInsideTransaction(entityManager -> entityManager.merge(country));
    }

    public void delete(Country country) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(country)));
    }
}
