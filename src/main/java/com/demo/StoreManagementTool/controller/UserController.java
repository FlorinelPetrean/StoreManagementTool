package com.demo.StoreManagementTool.controller;

import com.demo.StoreManagementTool.model.dto.DtoMapper;
import com.demo.StoreManagementTool.model.dto.JwtResponse;
import com.demo.StoreManagementTool.model.dto.UserDetails;
import com.demo.StoreManagementTool.model.dto.entitydto.IDto;
import com.demo.StoreManagementTool.model.dto.entitydto.UserDto;
import com.demo.StoreManagementTool.model.entity.AppUser;
import com.demo.StoreManagementTool.service.ICrudService;
import com.demo.StoreManagementTool.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController extends CrudController<AppUser, UserDto> {
    private final UserService userService;

    public UserController(ICrudService<AppUser> service, DtoMapper dtoMapper) {
        super(service, dtoMapper);
        this.userService = (UserService) service;
    }

    @GetMapping(path = "/u/{username}")
    public IDto<AppUser> getUserByUsername(@PathVariable String username) {
        AppUser user = userService.findByUsername(username);
        return dtoMapper.getDto(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody UserDetails userDetails) throws Exception {
        AppUser user;
        try {
            user = this.userService.login(userDetails.getUsername(), userDetails.getPassword());
        }
        catch (Exception e) {
            throw new Exception("Invalid Credentials", e);
        }

        return new JwtResponse(user.getUsername(), user.getRole());
    }

}
