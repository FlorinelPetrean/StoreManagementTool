package com.demo.StoreManagementTool.service;

import com.demo.StoreManagementTool.model.entity.Product;
import com.demo.StoreManagementTool.repository.CrudRepository;
import com.demo.StoreManagementTool.utils.BeanUtil;

public class ProductService extends CrudService<Product> {
    public ProductService(CrudRepository<Product> crudRepository, BeanUtil<Product> beanUtil) {
        super(crudRepository, beanUtil);
    }
}
