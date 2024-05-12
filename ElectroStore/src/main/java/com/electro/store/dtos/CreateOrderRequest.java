package com.electro.store.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreateOrderRequest {

    @NotBlank(message = "Cart is is required!!")
    private String cartId;

    @NotBlank(message = "Cart is is required!!")
    private String userId;

    private String orderStatus="PENDING";
    private String paymentStatus="NOTPAID";

    @NotBlank(message = "Address is required!!")
    private String billingAddress;

    @NotBlank(message = "Phone number is required!!")
    private String billingPhone;

    @NotBlank(message = "Billing name is required!!")
    private String billingName;

}
