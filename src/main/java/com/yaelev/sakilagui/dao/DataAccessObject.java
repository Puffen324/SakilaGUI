package com.yaelev.sakilagui.dao;

import java.util.List;

public interface DataAccessObject <T>{
    void create(T object);
    List<T> read();
    void update(T object);
    void delete(T object);

}
