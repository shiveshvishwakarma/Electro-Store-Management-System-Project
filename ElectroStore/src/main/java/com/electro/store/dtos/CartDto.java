package com.electro.store.dtos;

import com.electro.store.entites.CartItem;
import com.electro.store.entites.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {

    private String cartId;
    private Date createdAt;
    private UserDto user;
    private List<CartItemDto> items= new ArrayList<>();



}
