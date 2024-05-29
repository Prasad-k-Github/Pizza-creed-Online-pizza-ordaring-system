package com.EAD2.pizzacreed.service.implement;

import com.EAD2.pizzacreed.updateDetails.productDetailsUpdate;
import com.EAD2.pizzacreed.entity.product;
import com.EAD2.pizzacreed.repository.productRepository;
import com.EAD2.pizzacreed.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class productServiceImplement implements productService {

    @Autowired
    private productRepository productRepository;

    @Override
    public void addProduct(product product) {
        productRepository.save(product);
    }

    @Override
    public List<product> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public product getProductID(Integer productId) {
        product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Product ID" + productId));
        return product;
    }

    @Override
    public void deleteProduct(Integer productId) {

        //______check the product is in the database or not_____\\

        product product = productRepository
                .findById(productId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Product ID" + productId));

        productRepository.delete(product);
    }

    @Override
    public void updateProduct(Integer productId, product product) {

        //______check the product is in the database or not_____\\

        productRepository
                .findById(productId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Product ID" + productId));

        product.setProductId(productId);
        productRepository.save(product);
    }

    @Override
    public void updateProductName(Integer productId, productDetailsUpdate productDetailsUpdate) {

        //______check the product is in the database or not_____\\

        product product = productRepository
                .findById(productId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Product ID" + productId));
        product.setProductName(productDetailsUpdate.getProductName());
        productRepository.save(product);
    }

    @Override
    public void updateProductSmallPrice(Integer productId, productDetailsUpdate productDetailsUpdate) {

        //______check the product is in the database or not_____\\

        product product = productRepository
                .findById(productId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Product ID" + productId));
        product.setSmallPrice(productDetailsUpdate.getSmallPrice());
        productRepository.save(product);
    }

    @Override
    public void updateProductRegularPrice(Integer productId, productDetailsUpdate productDetailsUpdate) {

        //______check the product is in the database or not_____\\

        product product = productRepository
                .findById(productId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Product ID" + productId));
        product.setRegularPrice(productDetailsUpdate.getRegularPrice());
        productRepository.save(product);
    }

    @Override
    public void updateProductLargePrice(Integer productId, productDetailsUpdate productDetailsUpdate) {

        //______check the product is in the database or not_____\\

        product product = productRepository
                .findById(productId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Product ID" + productId));
        product.setLargePrice(productDetailsUpdate.getLargePrice());
        productRepository.save(product);
    }
}
