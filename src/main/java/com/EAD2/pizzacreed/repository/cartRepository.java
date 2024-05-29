package com.EAD2.pizzacreed.repository;

import com.EAD2.pizzacreed.entity.cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cartRepository extends JpaRepository<cart, Integer> {
}
