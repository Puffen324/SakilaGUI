package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Inventory;
import com.yaelev.sakilagui.entity.Language;

import java.util.List;

public class LanguageDAO extends GenericDAO<Language>{

    public LanguageDAO() {
        super();
    }

    public void create(Language language) {
        executeInsideTransaction(entityManager -> entityManager.persist(language));

    }

    public List<City> read() {
        return entityManager.createNativeQuery("SELECT * FROM Language", Language.class).getResultList();
    }


    public void update(Language language) {
        executeInsideTransaction(entityManager -> entityManager.merge(language));
    }

    public void delete(Language language) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(language)));
    }
}
