package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Rental;
import com.yaelev.sakilagui.entity.Staff;

import java.util.List;

public class StaffDAO extends GenericDAO<Staff>{

    public StaffDAO() {
        super();
    }

    public void create(Staff staff) {
        executeInsideTransaction(entityManager -> entityManager.persist(staff));

    }

    public List<Staff> read() {
        return entityManager.createNativeQuery("SELECT * FROM Staff", Staff.class).getResultList();
    }


    public void update(Staff staff) {
        executeInsideTransaction(entityManager -> entityManager.merge(staff));
    }

    public void delete(Staff staff) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(staff)));
    }
}
