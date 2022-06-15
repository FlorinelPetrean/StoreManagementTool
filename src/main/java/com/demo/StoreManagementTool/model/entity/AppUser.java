package com.demo.StoreManagementTool.model.entity;


import com.demo.StoreManagementTool.model.dto.entitydto.IDto;
import com.demo.StoreManagementTool.model.dto.entitydto.UserDto;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements IEntity<AppUser> {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;


    @Column
    private String address;


    @Column
    private String role;


    @Override
    public AppUser toEntity(IDto<AppUser> dto) {
        UserDto userDto = (UserDto) dto;
        return AppUser.builder()
                .id((userDto.getId()))
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .address(userDto.getAddress())
                .role(userDto.getRole())
                .build();
    }
}
