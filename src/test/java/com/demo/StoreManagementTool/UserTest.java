package com.demo.StoreManagementTool;

import com.demo.StoreManagementTool.model.entity.AppUser;
import com.demo.StoreManagementTool.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
public class UserTest {
    private final UserService userService;

    @Test
    void testLogin() {
        AppUser user = AppUser.builder()
                .username("test")
                .password("test")
                .address("address")
                .role("USER")
                .build();
        userService.create(user);

        AppUser createdUser = userService.findByUsername("test");
        AppUser loggedUser = userService.login("test", "test");

        assert createdUser.getId().equals(loggedUser.getId());
    }

}
