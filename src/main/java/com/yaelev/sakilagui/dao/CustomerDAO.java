package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Country;
import com.yaelev.sakilagui.entity.Customer;

import java.util.List;

public class CustomerDAO extends GenericDAO<Customer> {

    public CustomerDAO() {
        super();
    }

    public void create(Customer customer) {
        executeInsideTransaction(entityManager -> entityManager.persist(customer));

    }

    public List<City> read() {
        return entityManager.createNativeQuery("SELECT * FROM Customer", Customer.class).getResultList();
    }


    public void update(Customer customer) {
        executeInsideTransaction(entityManager -> entityManager.merge(customer));
    }

    public void delete(Customer customer) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(customer)));
    }
}
