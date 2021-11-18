package com.geekbrains.balyanova.spring.web.services;

import com.geekbrains.balyanova.spring.web.data.Product;
import com.geekbrains.balyanova.spring.web.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changeCost(Long productId, Integer delta) {
        Product product = productRepository.findProductById(productId);
        product.setCost(product.getCost() + delta);
    }
}
