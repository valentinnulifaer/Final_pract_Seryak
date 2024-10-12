package com.example.final_pract.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя пользователя не может быть пустым")
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 8)
    private String password;

    @Email(message = "Некорректный email")
    @NotBlank(message = "Email не может быть пустым")
    private String email;

    private boolean active = true;

    @Transient
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles;

    @Override
    public Set<RoleEntity> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public void setUsername(String username) {
        this.username= username;
    }

    public void setPassword(String password) {
        this.password= password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active= active;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles= roles;
    }
}
