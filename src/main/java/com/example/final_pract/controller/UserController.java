package com.example.final_pract.controller;

import com.example.final_pract.entity.UserEntity;
import com.example.final_pract.entity.RoleEntity; // Убедитесь, что этот импорт присутствует
import com.example.final_pract.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        List<UserEntity> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        UserEntity user = new UserEntity();
        user.setRoles(new HashSet<>()); // Инициализация пустого множества ролей
        model.addAttribute("user", user);
        model.addAttribute("roles", userService.getAllRoles());
        return "userForm";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("user") UserEntity user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roles", userService.getAllRoles());
            return "userForm";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Long id, Model model) {
        UserEntity user = userService.findById(id);
        if (user == null) {
            return "redirect:/users";
        }

        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>()); // Инициализация множества ролей, если оно null
        }

        model.addAttribute("user", user);
        model.addAttribute("roles", userService.getAllRoles());
        return "userForm";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid @ModelAttribute("user") UserEntity user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roles", userService.getAllRoles());
            return "userForm";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
