package com.EAD2.pizzacreed.service.implement;

import com.EAD2.pizzacreed.entity.basket;
import com.EAD2.pizzacreed.entity.product;
import com.EAD2.pizzacreed.repository.basketRepository;
import com.EAD2.pizzacreed.repository.productRepository;
import com.EAD2.pizzacreed.service.basketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class basketServiceImplement implements basketService {

    @Autowired
    private basketRepository basketRepository;

    @Autowired
    private productRepository productRepository;

    @Override
    public void addToBasket(basket basket) {
        product product = productRepository.findById(basket.getProduct().getProductId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Product ID: " + basket.getProduct().getProductId())
        );
        double price;
        switch (basket.getSizeOfPizza().toLowerCase()) {
            case "small":
                price = product.getSmallPrice();
                break;
            case "regular":
                price = product.getRegularPrice();
                break;
            case "large":
                price = product.getLargePrice();
                break;
            default:
                throw new IllegalArgumentException("Invalid size: " + basket.getSizeOfPizza());
        }
        basket.setTotalPrice(price * basket.getQuantity());
        basketRepository.save(basket);
    }

    @Override
    public List<basket> getBasket() {
        return basketRepository.findAll();
    }

    @Override
    public void deleteFromBasket(Integer basketId) {
        basket basket = basketRepository
                .findById(basketId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Basket ID: " + basketId));
        basketRepository.delete(basket);
    }

    @Override
    public Map<String, Object> checkout() {
        List<basket> baskets = basketRepository.findAll();
        if (baskets == null || baskets.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No items in basket to checkout");
        }

        double totalAmount = baskets.stream().mapToDouble(basket::getTotalPrice).sum();
        basketRepository.deleteAll();

        Map<String, Object> response = new HashMap<>();
        response.put("baskets", baskets);
        response.put("totalAmount", totalAmount);

        return response;
    }

    @Override
    public Map<String, Object> checkoutWithBasketId(Integer basketId) {
        basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Basket ID: " + basketId));

        double totalAmount = basket.getTotalPrice();
        basketRepository.delete(basket);

        Map<String, Object> response = new HashMap<>();
        response.put("basket", basket);
        response.put("totalAmount", totalAmount);

        return response;
    }
}
