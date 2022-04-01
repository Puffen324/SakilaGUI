package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.Actor;
import com.yaelev.sakilagui.entity.Address;

import java.util.List;

public class AddressDAO extends GenericDAO<Address>{
    public void create(Address address) {
        executeInsideTransaction(entityManager -> entityManager.persist(address));

    }

    public List<Address> read() {
        return entityManager.createNativeQuery("SELECT * FROM Address", Address.class).getResultList();
    }


    public void update(Address address) {
        executeInsideTransaction(entityManager -> entityManager.merge(address));
    }

    public void delete(Address address) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(address)));
    }
}
