package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.Actor;
import java.util.List;

public class ActorDAO extends GenericDAO<Actor> {
    public ActorDAO() {
        super();
    }

    public void create(Actor actor) {
        executeInsideTransaction(entityManager -> entityManager.persist(actor));
    }

    public List<Actor> read() {
        return entityManager.createNativeQuery("SELECT * FROM Actor", Actor.class).getResultList();
    }

    public void update(Actor actor) {
        executeInsideTransaction(entityManager -> entityManager.merge(actor));
    }

    public void delete(Actor actor) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(actor)));
    }

}



