package com.electro.store.repostories;

import com.electro.store.entites.Cart;
import com.electro.store.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, String> {

    Optional<Cart> findByUser(User user);
}
