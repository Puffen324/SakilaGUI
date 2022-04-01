package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.Category;
import com.yaelev.sakilagui.entity.City;

import java.util.List;

public class CityDAO extends GenericDAO<City> {

    public CityDAO() {
        super();
    }

    public void create(City city) {
        executeInsideTransaction(entityManager -> entityManager.persist(city));

    }

    public List<City> read() {
        return entityManager.createNativeQuery("SELECT * FROM City", City.class).getResultList();
    }


    public void update(City city) {
        executeInsideTransaction(entityManager -> entityManager.merge(city));
    }

    public void delete(City city) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(city)));
    }
}
