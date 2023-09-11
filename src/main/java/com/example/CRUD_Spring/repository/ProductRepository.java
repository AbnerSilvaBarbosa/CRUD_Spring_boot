package com.example.CRUD_Spring.repository;

import com.example.CRUD_Spring.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {

    List<Product> findAllByActiveTrue();

}
