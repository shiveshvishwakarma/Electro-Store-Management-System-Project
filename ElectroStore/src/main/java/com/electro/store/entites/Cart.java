package com.electro.store.entites;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cart")
public class Cart {

    @Id
    private String cartId;
    private Date createdAt;
    @OneToOne
    private User user;

    //mapping cart-items
     @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CartItem>  items= new ArrayList<>();
}
