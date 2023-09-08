package com.example.CRUD_Spring.controllers;

import com.example.CRUD_Spring.DTO.RequestProductDTO;
import com.example.CRUD_Spring.DTO.RequestUpdateProductDTO;
import com.example.CRUD_Spring.domain.product.Product;
import com.example.CRUD_Spring.exceptions.ProductNotFoundException;
import com.example.CRUD_Spring.services.ProductServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<Product> allProducts = productServices.getAllProducts();
        return ResponseEntity.ok(allProducts);

    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProductDTO body){
        Product product = productServices.addProduct(body);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Valid RequestProductDTO body){
        try {
            Product product = productServices.updateProductById(id,body);
            return ResponseEntity.ok(product);
        }catch (ProductNotFoundException e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        try {
            String product = productServices.deleteProductById(id);
            return ResponseEntity.ok(product);
        }catch (ProductNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
