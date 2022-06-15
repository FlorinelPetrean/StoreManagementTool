package com.demo.StoreManagementTool.service;

import com.demo.StoreManagementTool.model.entity.Product;
import com.demo.StoreManagementTool.repository.CrudRepository;
import com.demo.StoreManagementTool.repository.ProductRepository;
import com.demo.StoreManagementTool.utils.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
public class ProductService extends CrudService<Product> {
    private final ProductRepository productRepository;
    public ProductService(CrudRepository<Product> crudRepository, BeanUtil<Product> beanUtil) {
        super(crudRepository, beanUtil);
        this.productRepository = (ProductRepository) crudRepository;
    }
}
