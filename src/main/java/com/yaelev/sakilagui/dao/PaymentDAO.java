package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.City;
import com.yaelev.sakilagui.entity.Language;
import com.yaelev.sakilagui.entity.Payment;

import java.util.List;

public class PaymentDAO extends GenericDAO<Payment> {

    public PaymentDAO() {
        super();
    }

    public void create(Payment payment) {
        executeInsideTransaction(entityManager -> entityManager.persist(payment));

    }

    public List<City> read() {
        return entityManager.createNativeQuery("SELECT * FROM Payment", Payment.class).getResultList();
    }


    public void update(Payment payment) {
        executeInsideTransaction(entityManager -> entityManager.merge(payment));
    }

    public void delete(Payment payment) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(payment)));
    }
}
