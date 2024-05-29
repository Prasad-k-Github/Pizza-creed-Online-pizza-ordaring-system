package com.EAD2.pizzacreed.service.implement;

import com.EAD2.pizzacreed.entity.cart;
import com.EAD2.pizzacreed.repository.cartRepository;
import com.EAD2.pizzacreed.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class cartServiceImplement implements cartService {

    @Autowired
    private cartRepository cartRepository;

    @Override
    public void addToCart(cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<cart> getCart() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteToCart(Integer cartId) {

        cart cart = cartRepository
                .findById(cartId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Product ID" + cartId));

        cartRepository.delete(cart);
    }
}
