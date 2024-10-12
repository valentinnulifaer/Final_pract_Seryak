package com.example.final_pract.service;

import com.example.final_pract.entity.UserEntity;
import com.example.final_pract.entity.RoleEntity;
import com.example.final_pract.repository.UserRepository;
import com.example.final_pract.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void updateUser(Long id, UserEntity user) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setRoles(user.getRoles());
            userRepository.save(existingUser);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
