package com.EAD2.pizzacreed.service;

import com.EAD2.pizzacreed.entity.cart;

import java.util.List;

public interface cartService {

    void addToCart(cart cart);

    List<cart> getCart();

    void deleteToCart(Integer cartId);

}
