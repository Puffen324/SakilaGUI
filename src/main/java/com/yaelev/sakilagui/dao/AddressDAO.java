package com.yaelev.sakilagui.dao;

import com.yaelev.sakilagui.entity.Address;

import java.util.List;

public class AddressDAO extends GenericDAO<Address>{
    public void create(Address address) {
        executeInsideTransaction(entityManager -> entityManager.createNativeQuery(
                "INSERT INTO address (address, address2, district, city_id, postal_code, phone, location, last_update)" +
                        "VALUES(?,?,?,?,?,?,(ST_GeomFromText('POINT (17.36316 62.28842)')),?)")
                        .setParameter(1, address.getAddress())
                        .setParameter(2, address.getAddress2())
                        .setParameter(3, address.getDistrict())
                        .setParameter(4, address.getCityId())
                        .setParameter(5, address.getPostalCode())
                        .setParameter(6, address.getPhone())
                        .setParameter(7, address.getLastUpdate())
                        .executeUpdate());
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
