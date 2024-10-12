package com.example.final_pract.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    USER, MANAGER, ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
