package com.electro.store.services;

import com.electro.store.dtos.CreateOrderRequest;
import com.electro.store.dtos.OrderDto;
import com.electro.store.dtos.PageableResponce;

import java.util.List;

public interface OrderService {


    //create order
    OrderDto createOrder(CreateOrderRequest orderDto);

    //remove order
    void removeOrder(String orderId);

    //get order of user
    List<OrderDto> getOrderOfUser(String userId);

    //get orders
    PageableResponce<OrderDto> getOrders(int pageNumber, int pageSize, String sortBy, String sortDir);

    //other methods(logic) related to order

}
