package com.example.final_pract.controller;

import com.example.final_pract.entity.RoleEntity;
import com.example.final_pract.entity.UserEntity;
import com.example.final_pract.repository.RoleRepository;
import com.example.final_pract.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import java.util.Collections;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        List<RoleEntity> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserEntity user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<RoleEntity> roles = roleRepository.findAll();
            model.addAttribute("roles", roles);
            return "register";
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("message", "Пользователь с таким именем уже существует");
            List<RoleEntity> roles = roleRepository.findAll();
            model.addAttribute("roles", roles);
            return "register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity userRole = roleRepository.findByName(user.getRole());
        if (userRole == null) {
            userRole = roleRepository.findByName("ROLE_USER"); // Роль по умолчанию
        }
        user.setRoles(Collections.singleton(userRole));
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
