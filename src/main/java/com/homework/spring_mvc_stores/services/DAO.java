package com.homework.spring_mvc_stores.services;

import java.util.List;
import java.util.Optional;

public interface DAO<E> {
    List<E> getAll();
    Optional<E> findById(Integer id);
    Status save(E entity);
    Status update(E entity);
    Status delete(Integer id);
}
