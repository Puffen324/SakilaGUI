package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.ActorEntity;

import javax.persistence.*;
import java.util.List;

public class DataEntityManger implements DataAccessObject {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public void create2(ActorEntity actor) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.createNativeQuery("INSERT INTO Actor(first_name,last_name)"+
                            "VALUES (?,?)")
                    .setParameter(1,actor.getFirstName())
                    .setParameter(2,actor.getLastName())
                    .executeUpdate();
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void create(Object object) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.createNativeQuery("INSERT INTO Actor(first_name,last_name)"+
                            "VALUES (?,?)")
                    .setParameter(1,object)
                    .setParameter(2,object)
                    .executeUpdate();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }

    }
    @Override
    public List read(){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<ActorEntity> actorObject = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            actorObject = entityManager.createNativeQuery("SELECT * FROM Actor",ActorEntity.class).getResultList();

            for(ActorEntity actor : actorObject){
                System.out.println(actor.getFirstName());
            }
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return actorObject;
    }

    @Override
    public void update(Object object) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();

     /*       ActorEntity actor = entityManager.find(ActorEntity.class,object);*/
            // förändring här vad vi nu skall ha
            entityManager.merge(object);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Object object) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
           /* Query query = entityManager.createNativeQuery("DELETE FROM Actor a WHERE a.actorId = object");
            query.executeUpdate();*/
            entityManager.remove(object);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
