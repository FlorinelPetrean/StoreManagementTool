package com.demo.StoreManagementTool.repository;


import com.demo.StoreManagementTool.model.entity.AppUser;
import com.demo.StoreManagementTool.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, CrudRepository<Product> {
}
