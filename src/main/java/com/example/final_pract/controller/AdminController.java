package com.example.final_pract.controller;

import com.example.final_pract.entity.UserEntity;
import com.example.final_pract.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }
}
