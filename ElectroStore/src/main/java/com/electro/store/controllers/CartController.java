package com.electro.store.controllers;


import com.electro.store.dtos.AddItemToCartRequest;
import com.electro.store.dtos.ApiResponceMessage;
import com.electro.store.dtos.CartDto;
import com.electro.store.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    //add items to cart
    @PostMapping("/{userId}")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable String userId, @RequestBody AddItemToCartRequest request){
        CartDto cartDto = cartService.addItemToCart(userId, request);
        return  new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @DeleteMapping("{userId}/items/{itemId}")
    public ResponseEntity<ApiResponceMessage> removeItemFromCart(@PathVariable String userId, @PathVariable int ItemId) {
        cartService.removeItemFromCart(userId, ItemId);
        ApiResponceMessage responce = ApiResponceMessage.builder()
                .message("item is removed !!")
                .success(true)
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(responce, HttpStatus.OK);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponceMessage> clearCart(@PathVariable String userId, @PathVariable int ItemId){
        cartService.clearCart(userId);
        ApiResponceMessage responce = ApiResponceMessage.builder()
                .message("Not cart is blank !!")
                .success(true)
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(responce, HttpStatus.OK);


    }

    //add items to cart
    @GetMapping("/{userId}")
    public ResponseEntity<CartDto> getCart(@PathVariable String userId){
        CartDto cartDto = cartService.getCartByUser(userId);
        return  new ResponseEntity<>(cartDto, HttpStatus.OK);
    }
}
