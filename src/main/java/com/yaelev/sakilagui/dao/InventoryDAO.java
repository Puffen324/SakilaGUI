package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Film;
import com.yaelev.sakilagui.entity.Inventory;

import java.util.List;

public class InventoryDAO extends GenericDAO<Inventory>{

    public InventoryDAO() {
        super();
    }

    public void create(Inventory inventory) {
        executeInsideTransaction(entityManager -> entityManager.persist(inventory));

    }

    public List<Inventory> read() {
        return entityManager.createNativeQuery("SELECT * FROM Inventory", Inventory.class).getResultList();
    }


    public void update(Inventory inventory) {
        executeInsideTransaction(entityManager -> entityManager.merge(inventory));
    }

    public void delete(Inventory inventory) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(inventory)));
    }
}
