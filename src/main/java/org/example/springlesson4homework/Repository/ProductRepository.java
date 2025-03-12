package org.example.springlesson4homework.Repository;

import lombok.Data;
import org.example.springlesson4homework.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Data
@Repository
public class ProductRepository {

    public List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
    }
}
