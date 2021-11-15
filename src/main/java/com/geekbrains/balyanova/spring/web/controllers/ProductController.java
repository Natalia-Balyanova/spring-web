package com.geekbrains.balyanova.spring.web.controllers;

import com.geekbrains.balyanova.spring.web.model.Product;
import com.geekbrains.balyanova.spring.web.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String showStudentsPage(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "products_page";
    }

    @GetMapping("/products/{id}")
    public String showProductsPage(Model model, @PathVariable Long id) {
        Product product = productRepository.findProductById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }

}
