package com.EAD2.pizzacreed.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class cart {

    @Id
    @GeneratedValue
    private int cartId;
    private int productID;
    private int userID;
    private String sizeOfPizza;
    private int quantity;
    private double totalPrice;

}
