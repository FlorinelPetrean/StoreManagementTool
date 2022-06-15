package com.demo.StoreManagementTool.model.dto.entitydto;

public interface IDto<T> {
    IDto<T> toDto(T entity);
}
