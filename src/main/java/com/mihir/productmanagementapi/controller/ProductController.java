package com.mihir.productmanagementapi.controller;

import com.mihir.productmanagementapi.entity.Product;
import com.mihir.productmanagementapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product createProduct = productService.createProduct(product);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/api/products/{id}")
    public Product updateproduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}