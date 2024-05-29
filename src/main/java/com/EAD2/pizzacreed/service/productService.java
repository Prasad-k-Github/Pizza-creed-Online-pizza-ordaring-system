package com.EAD2.pizzacreed.service;

import com.EAD2.pizzacreed.updateDetails.productDetailsUpdate;
import com.EAD2.pizzacreed.entity.product;

import java.util.List;

public interface productService {
    void addProduct(product product);

    List<product> getProduct();

    product getProductID(Integer productId);

    void deleteProduct(Integer productId);

    void updateProduct(Integer productId, product product);

    void updateProductName(Integer productId, productDetailsUpdate productDetailsUpdate);

    void updateProductSmallPrice(Integer productId, productDetailsUpdate productDetailsUpdate);

    void updateProductRegularPrice(Integer productId, productDetailsUpdate productDetailsUpdate);

    void updateProductLargePrice(Integer productId, productDetailsUpdate productDetailsUpdate);

}
