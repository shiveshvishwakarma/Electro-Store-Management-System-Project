package com.electro.store.repostories;

import com.electro.store.entites.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
