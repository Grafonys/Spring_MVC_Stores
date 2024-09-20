package com.homework.spring_mvc_stores.services;

import com.homework.spring_mvc_stores.models.Store;
import com.homework.spring_mvc_stores.repositories.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    public static final String[] VALID_CATEGORIES = {"Продовольственный", "Хозяйственный", "Спортивный"};

    private final StoreRepository repository;

    @Override
    public List<Store> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Store> findById(Integer id) {
        return Optional.of(repository.findById(id))
                .orElse(Optional.empty());
    }

    public List<Store> findByName(String name) {
        return repository.findStoresByNameContainsIgnoreCase(name);
    }

    public List<Store> findByCategory(String category) {
        return repository.findStoresByCategoryContainsIgnoreCase(category);
    }

    public List<Store> findByAddress(String address) {
        return repository.findStoresByAddressContainsIgnoreCase(address);
    }

    @Override
    public Status save(Store entity) {
        repository.save(entity);
        return Status.SUCCESS;
    }

    @Override
    public Status update(Store entity) {
        return save(entity);
    }

    @Override
    public Status delete(Integer id) {
        repository.deleteById(id);
        return Status.SUCCESS;
    }
}
