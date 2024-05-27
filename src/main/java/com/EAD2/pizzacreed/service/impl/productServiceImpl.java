package com.EAD2.pizzacreed.service.impl;

import com.EAD2.pizzacreed.entity.product;
import com.EAD2.pizzacreed.repository.productRepository;
import com.EAD2.pizzacreed.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productServiceImpl implements productService {

    @Autowired
    private productRepository productRepository;

    @Override
    public void addProduct(product product) {
        productRepository.save(product);
    }
}
