package com.example.CRUD_Spring.controllers;
import com.example.CRUD_Spring.DTO.RequestProductDTO;
import com.example.CRUD_Spring.domain.product.Product;
import com.example.CRUD_Spring.services.ProductServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity disableProduct(@PathVariable String id){
        try {
            Product product = productServices.disableProductById(id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity activatedProduct(@PathVariable String id){
        try{
            Product product = productServices.activatedProductById(id);
            return ResponseEntity.ok(product);
        }catch(RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
