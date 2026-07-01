package org.example.chua_bai_ss01.models.services;

import org.example.chua_bai_ss01.models.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    List<Product> products = List.of(
            new Product(1, "Iphone 14", 2000.0),
            new Product(2, "Iphone 14 Pro", 3000.0),
            new Product(3, "Iphone 14 Pro Max", 4000.0)
    );

    public List<Product> getAllProducts() {
        return products;
    }

}
