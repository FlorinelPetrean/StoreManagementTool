package com.demo.StoreManagementTool.repository;

import com.demo.StoreManagementTool.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.StoreManagementTool.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>, CrudRepository<AppUser> {
    Optional<AppUser> findAppUserByUsername(String username);
}
