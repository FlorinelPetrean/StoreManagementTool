package com.demo.StoreManagementTool.controller;

import com.demo.StoreManagementTool.model.dto.DtoMapper;
import com.demo.StoreManagementTool.model.dto.entitydto.ProductDto;
import com.demo.StoreManagementTool.model.entity.Product;
import com.demo.StoreManagementTool.service.ICrudService;
import com.demo.StoreManagementTool.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController extends CrudController<Product, ProductDto> {
    private final ProductService productService;

    public ProductController(ICrudService<Product> service, DtoMapper dtoMapper) {
        super(service, dtoMapper);
        this.productService = (ProductService) service;
    }
}
