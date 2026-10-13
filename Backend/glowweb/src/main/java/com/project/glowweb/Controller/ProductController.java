package com.project.glowweb.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.glowweb.Entity.Product;
import com.project.glowweb.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // ADD PRODUCT
    @PostMapping
    public ResponseEntity<Product> addProduct(
            @RequestBody Product product) {

        Product savedProduct =
                productService.addProduct(product);

        return ResponseEntity.ok(savedProduct);
    }


    // GET ALL PRODUCTS
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity.ok(
                productService.getAllProducts()
        );
    }


    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable String id) {

        return ResponseEntity.ok(
                productService.getProductById(id)
        );
    }


    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable String id,
            @RequestBody Product product) {

        return ResponseEntity.ok(
                productService.updateProduct(id, product)
        );
    }


    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable String id) {

        productService.deleteProduct(id);

        return ResponseEntity.ok(
                "Product deleted successfully"
        );
    }

@PostMapping("/bulk")
public ResponseEntity<List<Product>> addProducts(
        @RequestBody List<Product> products) {

    List<Product> savedProducts =
            products.stream()
                    .map(productService::addProduct)
                    .toList();

    return ResponseEntity.ok(savedProducts);
}

}