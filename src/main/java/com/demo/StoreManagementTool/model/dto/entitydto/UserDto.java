package com.demo.StoreManagementTool.model.dto.entitydto;

import com.demo.StoreManagementTool.model.entity.AppUser;
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
public class UserDto implements IDto<AppUser> {
    private Long id;

    private String username;

    private String password;

    private String address;


    private String role;

    public UserDto toDto(AppUser user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .address(user.getAddress())
                .role(user.getRole())
                .build();
    }
}
