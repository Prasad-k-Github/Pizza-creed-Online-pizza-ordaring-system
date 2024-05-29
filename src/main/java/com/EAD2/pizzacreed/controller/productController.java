package com.EAD2.pizzacreed.controller;
import com.EAD2.pizzacreed.updateDetails.productDetailsUpdate;
import com.EAD2.pizzacreed.entity.product;
import com.EAD2.pizzacreed.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private productService productService;

    @PostMapping("/add")
    private String addProduct(@RequestBody product product){
        productService .addProduct(product);
        return "Product Add successful";
    }

    @GetMapping("/get")
    public List<product> getProduct(){
        return productService.getProduct();
    }

    @GetMapping("/Get_With_ID")
    public product getProductID(@RequestParam Integer productId){
        return productService.getProductID(productId);
    }

    @DeleteMapping("/Delete_product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer
                                                      productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update_product/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Integer
                                                      productId,@RequestBody product product){
        productService.updateProduct(productId,product);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update_product_name/{productId}")
    public ResponseEntity<Void> updateProductName(@PathVariable Integer
                                                          productId, @RequestBody productDetailsUpdate productDetailsUpdate){
        productService.updateProductName(productId, productDetailsUpdate);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update_product_Small_Price/{productId}")
    public ResponseEntity<Void> updateProductSmallPrice(@PathVariable Integer
                                                                productId, @RequestBody productDetailsUpdate productDetailsUpdate){
        productService.updateProductSmallPrice(productId,
                productDetailsUpdate);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update_product_Regular_Price/{productId}")
    public ResponseEntity<Void> updateProductRegularPrice(@PathVariable
                                                          Integer productId, @RequestBody productDetailsUpdate productDetailsUpdate){
        productService.updateProductRegularPrice(productId,
                productDetailsUpdate);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update_product_Large_Price/{productId}")
    public ResponseEntity<Void> updateProductLargePrice(@PathVariable Integer
                                                                productId, @RequestBody productDetailsUpdate productDetailsUpdate){
        productService.updateProductLargePrice(productId,
                productDetailsUpdate);
        return ResponseEntity.noContent().build();
    }
}