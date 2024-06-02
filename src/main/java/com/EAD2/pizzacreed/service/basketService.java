package com.EAD2.pizzacreed.service;

import com.EAD2.pizzacreed.entity.basket;

import java.util.List;
import java.util.Map;

public interface basketService {

    void addToBasket(basket basket);

    List<basket> getBasket();

    void deleteFromBasket(Integer basketId);

    Map<String, Object> checkout();

    Map<String, Object> checkoutWithBasketId(Integer basketId);
}
