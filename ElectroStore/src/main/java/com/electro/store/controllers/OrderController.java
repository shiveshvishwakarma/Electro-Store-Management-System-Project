package com.electro.store.controllers;


import com.electro.store.dtos.ApiResponceMessage;
import com.electro.store.dtos.CreateOrderRequest;
import com.electro.store.dtos.OrderDto;
import com.electro.store.dtos.PageableResponce;
import com.electro.store.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //create
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        OrderDto order = orderService.createOrder(request);
        return new ResponseEntity<>(order, HttpStatus.CREATED);

    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<ApiResponceMessage> removeOrder(@PathVariable String orderId) {
        orderService.removeOrder(orderId);
        ApiResponceMessage responceMessage = ApiResponceMessage.builder()
                .status(HttpStatus.OK)
                .message("order is removed!!")
                .success(true)
                .build();
        return new ResponseEntity<>(responceMessage, HttpStatus.OK);

    }

    //get order of the user

    @GetMapping("/user/userId")
    public ResponseEntity<List<OrderDto>> getOrderOfUser(@PathVariable String userId) {
        List<OrderDto> ordersOfUser = orderService.getOrderOfUser(userId);
        return new ResponseEntity<>(ordersOfUser, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<PageableResponce<OrderDto>> getOrders(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir




    ) {
        PageableResponce<OrderDto> orders = orderService.getOrders(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(orders, HttpStatus.OK);


    }
}
