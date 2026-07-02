package org.example.chua_bai_ss01.controllers;


import ch.qos.logback.classic.spi.TurboFilterList;
import lombok.RequiredArgsConstructor;
import org.example.chua_bai_ss01.models.entities.Product;
import org.example.chua_bai_ss01.models.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(name = "search",defaultValue = "") String search
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        productService.getAllProducts(search)
                );
    }

    // định API thêm mới
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> createProduct(@RequestBody Product req) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.addProduct(req));
    }

    // API cập nhật - giá trị trên đường dẫn
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Integer id, // id đối tượng muốn cập nhật
            @RequestBody Product req // giá trị mới muốn cập nhật vào
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.updateProduct(req, id));
    }

    // API xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable(name = "id") Integer productId
    ) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
