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
public class user {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String address;

    private int phoneNo;

    private String password;
}
