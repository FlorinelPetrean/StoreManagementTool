package com.demo.StoreManagementTool.model.dto;

import com.demo.StoreManagementTool.model.dto.entitydto.IDto;
import com.demo.StoreManagementTool.model.dto.entitydto.ProductDto;
import com.demo.StoreManagementTool.model.dto.entitydto.UserDto;
import com.demo.StoreManagementTool.model.entity.AppUser;
import com.demo.StoreManagementTool.model.entity.IEntity;
import com.demo.StoreManagementTool.model.entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DtoMapper {

    private final HashMap<Class, Class> _handlerMap = new HashMap<>();
//    @Autowired
    private final ApplicationContext context;

    public DtoMapper(ApplicationContext context) {
        this.context = context;
        _handlerMap.put(UserDto.class, AppUser.class);
        _handlerMap.put(AppUser.class, UserDto.class);
        _handlerMap.put(Product.class, ProductDto.class);
        _handlerMap.put(ProductDto.class, Product.class);
    }


    public <T> T getEntity(IDto<T> beanDTO) {
        Class handlerType = _handlerMap.get(beanDTO.getClass());
        try {
            IEntity<T> handler = (IEntity<T>) context.getBean(handlerType);
            return handler.toEntity(beanDTO);
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        return null;
    }


    public <T> IDto<T> getDto(T entityBean) {
        Class handlerType = _handlerMap.get(entityBean.getClass());
        try {
            IDto<T> handler = (IDto<T>) context.getBean(handlerType);
            return handler.toDto(entityBean);
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
