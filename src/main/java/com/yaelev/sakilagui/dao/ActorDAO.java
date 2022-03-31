package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.ActorEntity;
import java.util.List;

public class ActorDAO extends GenericDAO<ActorEntity> {

    public ActorDAO() {
        super();
    }

    public void create(ActorEntity actor) {
        executeInsideTransaction(entityManager -> entityManager.persist(actor));
    }

    public List<ActorEntity> read() {
        return entityManager.createNativeQuery("SELECT * FROM Actor", ActorEntity.class).getResultList();
    }

    public void update(ActorEntity actor) {
        executeInsideTransaction(entityManager -> entityManager.merge(actor));
    }

    public void delete(ActorEntity actor) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(actor)));
    }

}



