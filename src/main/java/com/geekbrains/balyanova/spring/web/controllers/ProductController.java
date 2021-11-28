package com.geekbrains.balyanova.spring.web.controllers;

import com.geekbrains.balyanova.hibernate.h2.Product;
import com.geekbrains.balyanova.hibernate.h2.SessionFactoryUtils;
import com.geekbrains.balyanova.spring.web.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

//    private SessionFactoryUtils sessionFactoryUtils;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_cost")
    public void changePrice(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changePrice(productId, delta);
    }
}
