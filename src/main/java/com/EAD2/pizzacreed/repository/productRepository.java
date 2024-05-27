package com.EAD2.pizzacreed.repository;

import com.EAD2.pizzacreed.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product, Integer> {
}
