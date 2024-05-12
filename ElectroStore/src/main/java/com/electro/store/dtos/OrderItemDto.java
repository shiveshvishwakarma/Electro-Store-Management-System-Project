package com.electro.store.dtos;

import com.electro.store.entites.Order;
import com.electro.store.entites.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemDto {

    private int orderItemId;

    private int quantity;

    private int totalPrice;

    private ProductDto product;




}
