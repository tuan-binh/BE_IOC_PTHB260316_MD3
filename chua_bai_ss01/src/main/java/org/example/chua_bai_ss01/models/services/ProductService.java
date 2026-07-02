package org.example.chua_bai_ss01.models.services;

import org.example.chua_bai_ss01.models.entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Iphone 14", 2000.0),
            new Product(2, "Iphone 14 Pro", 3000.0),
            new Product(3, "Iphone 14 Pro Max", 4000.0)
    ));

    public List<Product> getAllProducts(String search) {
        if (search == null || search.isEmpty()) {
            return products;
        }
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(search.toLowerCase()))
                .toList();
    }

    // chức năng thêm mới
    public Product addProduct(Product req) {
        // tìm id lớn nhất trong danh sách
        Product maxId = products.stream().max(Comparator.comparingInt(Product::getId)).orElse(null);

        // khởi tạo đối tượng mới
        Product newProduct = new Product(
                // nếu maxId tồn tại thì id + 1 không thì giá trị ban đầu là 1
                maxId != null ? maxId.getId() + 1 : 1,
                req.getName(),
                req.getPrice()
        );

        // lưu vào danh sách
        products.add(newProduct);

        // trả về sản phẩm vừa được thêm mới
        return newProduct;
    }

    // chức năng cập nhật
    public Product updateProduct(Product req, Integer id) {
        // tìm sản phẩm cần cập nhật
        Product productUpdate = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (productUpdate != null) {
            productUpdate.setName(req.getName());
            productUpdate.setPrice(req.getPrice());
        }

        return productUpdate;
    }

    // chức năng xóa
    public void deleteProduct(Integer id) {
        // tìm sản phẩm cần cập nhật
        Product productDelete = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (productDelete != null) {
            products.remove(productDelete);
        }
    }

}
