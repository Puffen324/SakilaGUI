package com.yaelev.sakilagui.dao;


import com.yaelev.sakilagui.entity.Store;

import java.util.List;

public class StoreDAO extends GenericDAO<Store>{
    public StoreDAO() {
        super();
    }

    public void create(Store store) {
        executeInsideTransaction(entityManager -> entityManager.persist(store));
    }

    public List<Store> read() {
        return entityManager.createNativeQuery("SELECT * FROM Store", Store.class).getResultList();
    }

    public void update(Store store) {
        executeInsideTransaction(entityManager -> entityManager.merge(store));
    }

    public void delete(Store store) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(store)));
    }
}
