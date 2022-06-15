package com.demo.StoreManagementTool.model.entity;


import com.demo.StoreManagementTool.model.dto.entitydto.IDto;
import com.demo.StoreManagementTool.model.dto.entitydto.ProductDto;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Product implements IEntity<Product>{

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private Double price;

    @Column
    private Long quantity;

    @Override
    public Product toEntity(IDto<Product> dto) {
        ProductDto productDto = (ProductDto) dto;
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();
    }
}
