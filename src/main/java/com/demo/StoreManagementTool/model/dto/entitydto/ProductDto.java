package com.demo.StoreManagementTool.model.dto.entitydto;

import com.demo.StoreManagementTool.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Builder
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements IDto<Product>{

    private Long id;

    private String name;

    private Double price;

    private Long quantity;

    @Override
    public IDto<Product> toDto(Product entity) {
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }
}
