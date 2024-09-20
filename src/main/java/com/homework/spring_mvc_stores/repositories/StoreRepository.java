package com.homework.spring_mvc_stores.repositories;

import com.homework.spring_mvc_stores.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    List<Store> findStoresByNameContainsIgnoreCase(String name);
    List<Store> findStoresByCategoryContainsIgnoreCase(String category);
    List<Store> findStoresByAddressContainsIgnoreCase(String address);
}
