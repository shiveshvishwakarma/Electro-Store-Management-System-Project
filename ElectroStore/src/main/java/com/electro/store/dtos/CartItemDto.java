package com.electro.store.dtos;

import com.electro.store.entites.Cart;
import com.electro.store.entites.Product;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemDto {

    private int cartItemId;
    private Product product;
    private int quantity;
    private int totelPice;



}
