package com.example.final_pract.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @EmbeddedId
    private OrderItemId id = new OrderItemId();

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @NotNull(message = "Количество не может быть пустым")
    @Min(value = 1, message = "Количество не может быть меньше 1")
    private Integer quantity;

    @NotNull(message = "Цена не может быть пустой")
    @DecimalMin(value = "0.0", inclusive = false, message = "Цена должна быть больше 0")
    private Double price;

    public OrderItemId getId() {
        return id;
    }

    public void setId(OrderItemId id) {
        this.id = id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order= order;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie= movie;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity= quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price= price;
    }
}
