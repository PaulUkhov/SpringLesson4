package org.example.springlesson4homework.services;

import lombok.AllArgsConstructor;
import org.example.springlesson4homework.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceProduct {
    private List<Product> products;

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
