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

public class product {

    @Id
    @GeneratedValue
    private int productId;
    private String productName;
    private double smallPrice;
    private double regularPrice;
    private double largePrice;
}
