package com.mihir.productmanagementapi.repository;

import com.mihir.productmanagementapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}