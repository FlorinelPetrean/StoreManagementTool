package com.demo.StoreManagementTool.controller;


import com.demo.StoreManagementTool.model.dto.DtoMapper;
import com.demo.StoreManagementTool.model.dto.entitydto.IDto;
import com.demo.StoreManagementTool.service.ICrudService;
import com.demo.StoreManagementTool.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public abstract class CrudController<T, U> {
    protected final ICrudService<T> service;
    protected final DtoMapper dtoMapper;

    @GetMapping(path = "/all")
    public List<IDto<T>> findAll() {
        List<T> all = service.findAll();
        return all.stream().map(dtoMapper::getDto).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public IDto<T> findById(@PathVariable Long id) {
        return dtoMapper.getDto(service.findById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Void> create(@RequestBody U bean) {
        T entity = dtoMapper.getEntity((IDto<T>) bean);
        service.create(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/modify/{id}")
    public ResponseEntity<Void> modify(@PathVariable Long id, @RequestBody U bean) {
        T entity = dtoMapper.getEntity((IDto<T>) bean);
        service.modify(id, entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> delete(@RequestBody U bean) {
        T entity = (T) dtoMapper.getEntity((IDto<T>) bean);
        service.delete(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
