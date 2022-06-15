package com.demo.StoreManagementTool.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T bean);

    void deleteById(Long id);

    void delete(T bean);
}
