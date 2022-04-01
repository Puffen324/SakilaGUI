package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.Actor;
import com.yaelev.sakilagui.entity.Category;

import java.util.List;

public class CategoryDAO extends GenericDAO<Category> {

    public CategoryDAO() {
        super();
    }

    public void create(Category category) {
        executeInsideTransaction(entityManager -> entityManager.persist(category));

    }

    public List<Category> read() {
        return entityManager.createNativeQuery("SELECT * FROM Category", Category.class).getResultList();
    }


    public void update(Category category) {
        executeInsideTransaction(entityManager -> entityManager.merge(category));
    }

    public void delete(Category category) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(category)));
    }

}
