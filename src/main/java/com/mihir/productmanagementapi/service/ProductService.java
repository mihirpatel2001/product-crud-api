package com.mihir.productmanagementapi.service;

import com.mihir.productmanagementapi.entity.Product;
import com.mihir.productmanagementapi.exception.ProductNotFoundException;
import com.mihir.productmanagementapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product updateProduct(Long id, Product productDetails) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found with id: " + id));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setCategory(productDetails.getCategory());
        product.setStatus(productDetails.getStatus());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found with id: " + id));

        productRepository.delete(product);
    }
}