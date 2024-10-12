package com.example.final_pract.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Дата заказа не может быть пустой")
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItemEntity> orderItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate= orderDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user= user;
    }

    public Set<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemEntity> orderItems) {
        this.orderItems= orderItems;
    }
}
