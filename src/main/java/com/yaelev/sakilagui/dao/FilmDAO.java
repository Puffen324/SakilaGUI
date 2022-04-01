package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Country;
import com.yaelev.sakilagui.entity.Customer;
import com.yaelev.sakilagui.entity.Film;

import java.util.List;

public class FilmDAO extends GenericDAO<Film>{

    public FilmDAO() {
        super();
    }

    public void create(Film film) {
        executeInsideTransaction(entityManager -> entityManager.persist(film));

    }

    public List<City> read() {
        return entityManager.createNativeQuery("SELECT * FROM Film", Film.class).getResultList();
    }


    public void update(Film film) {
        executeInsideTransaction(entityManager -> entityManager.merge(film));
    }

    public void delete(Film film) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(film)));
    }
}
