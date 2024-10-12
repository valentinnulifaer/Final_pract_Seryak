package com.example.final_pract.repository;

import com.example.final_pract.entity.OrderItemEntity;
import com.example.final_pract.entity.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemId> {

}
