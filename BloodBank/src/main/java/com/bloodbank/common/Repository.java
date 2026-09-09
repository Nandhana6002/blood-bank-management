package com.bloodbank.common;

import java.util.List;

public interface Repository<T, ID> {

    void save(T item);

    T findById(ID id);

    List<T> findAll();

    void update(T item);

    void delete(ID id);
}