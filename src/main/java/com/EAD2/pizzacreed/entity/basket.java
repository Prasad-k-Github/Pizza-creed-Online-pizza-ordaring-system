package com.EAD2.pizzacreed.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class basket {

    @Id
    @GeneratedValue
    private int basketID;

    @ManyToOne
    @JoinColumn(name = "productID", referencedColumnName = "productId")
    private product product;

    private String sizeOfPizza;
    private int quantity;
    private double totalPrice;
}
