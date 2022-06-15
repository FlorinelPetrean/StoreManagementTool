package com.demo.StoreManagementTool.model.entity;

import com.demo.StoreManagementTool.model.dto.entitydto.IDto;
public interface IEntity<T> {
    T toEntity(IDto<T> dto);
}
