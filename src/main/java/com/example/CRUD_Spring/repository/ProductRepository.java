package com.example.CRUD_Spring.repository;

import com.example.CRUD_Spring.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
