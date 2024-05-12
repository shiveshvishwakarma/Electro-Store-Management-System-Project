package com.electro.store.repostories;

import com.electro.store.entites.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Integer > {
}
