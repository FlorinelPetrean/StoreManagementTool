package com.demo.StoreManagementTool.service;


import com.demo.StoreManagementTool.model.entity.AppUser;
import com.demo.StoreManagementTool.repository.CrudRepository;
import com.demo.StoreManagementTool.repository.UserRepository;
import com.demo.StoreManagementTool.utils.BeanUtil;
import com.demo.StoreManagementTool.utils.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends CrudService<AppUser> {
    private final UserRepository userRepository;
    public UserService(CrudRepository<AppUser> crudRepository, BeanUtil<AppUser> beanUtil) {
        super(crudRepository, beanUtil);
        this.userRepository = (UserRepository) crudRepository;
    }

    public AppUser findByUsername(String username) {
        Optional<AppUser> optionalUser = userRepository.findAppUserByUsername(username);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new IllegalStateException("User with username=" + username + " does not exist");
    }

    @Override
    public AppUser create(AppUser bean) {
        String password = bean.getPassword();
        bean.setPassword(PasswordEncoder.encodePassword(password));
        return super.create(bean);
    }

    @Override
    public AppUser modify(Long id, AppUser bean) {
        return super.modify(id, bean);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public AppUser login(String username, String password) {
        AppUser user = findByUsername(username);
        String encryptedPassword = user.getPassword();
        if(PasswordEncoder.checkPassword(password, encryptedPassword)) {
            return user;
        }
        throw new IllegalStateException("Incorrect credentials");
    }
}
