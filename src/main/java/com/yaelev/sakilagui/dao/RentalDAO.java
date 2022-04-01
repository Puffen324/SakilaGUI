package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Payment;
import com.yaelev.sakilagui.entity.Rental;

import java.util.List;

public class RentalDAO extends GenericDAO<Rental>{

    public RentalDAO() {
        super();
    }

    public void create(Rental rental) {
        executeInsideTransaction(entityManager -> entityManager.persist(rental));

    }

    public List<City> read() {
        return entityManager.createNativeQuery("SELECT * FROM Rental", Rental.class).getResultList();
    }


    public void update(Rental rental) {
        executeInsideTransaction(entityManager -> entityManager.merge(rental));
    }

    public void delete(Rental rental) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(rental)));
    }
}
