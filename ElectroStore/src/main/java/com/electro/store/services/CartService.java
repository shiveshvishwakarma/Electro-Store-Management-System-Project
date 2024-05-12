package com.electro.store.services;

import com.electro.store.dtos.AddItemToCartRequest;
import com.electro.store.dtos.CartDto;

public interface CartService {

    //add items to cart
    //cart1 for user os not available: we will create the cart and then add the items
    //case2: cart available add the items to cart


    CartDto addItemToCart(String userId, AddItemToCartRequest request);


    //remove item from cart:
    void removeItemFromCart(String userId, int cartItem);

    //remove all items from cart
    void clearCart(String userId);

    CartDto getCartByUser(String userId);

}
