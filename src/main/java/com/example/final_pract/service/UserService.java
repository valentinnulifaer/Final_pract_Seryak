package com.example.final_pract.service;

import com.example.final_pract.entity.UserEntity;
import com.example.final_pract.entity.RoleEntity;

import java.util.List;

public interface UserService {
    void saveUser(UserEntity user);
    UserEntity findByUsername(String username);
    List<UserEntity> findAllUsers();

    List<RoleEntity> getAllRoles();
    UserEntity findById(Long id);
    void updateUser(Long id, UserEntity user);
    void deleteUser(Long id);
}
