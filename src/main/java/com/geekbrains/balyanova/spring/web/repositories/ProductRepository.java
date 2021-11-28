package com.geekbrains.balyanova.spring.web.repositories;

import com.geekbrains.balyanova.hibernate.h2.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 100),
                new Product(2L, "Bread Luxury", 200),
                new Product(3L, "Apple", 100),
                new Product(4L, "Milk", 70),
                new Product(5L, "Eggs", 100)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findProductById(Long id) {
        return products.stream().
                filter(p -> p.getId().equals(id)).
                findFirst().get();
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}

