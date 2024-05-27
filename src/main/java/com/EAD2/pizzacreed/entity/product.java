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
    private int Product_ID;
    private String  Product_Name;
    private double  Small_Price;
    private double  regular_Price;
    private double  Large_Price;
    private String Product_Image_Path;
}
