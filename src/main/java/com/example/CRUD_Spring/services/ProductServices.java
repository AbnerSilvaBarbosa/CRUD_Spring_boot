package com.example.CRUD_Spring.services;

import com.example.CRUD_Spring.DTO.RequestProductDTO;
import com.example.CRUD_Spring.domain.product.Product;
import com.example.CRUD_Spring.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAllByActiveTrue();
        return products;
    }

    public Product addProduct(RequestProductDTO requestProductDTO){
        Product product = new Product(requestProductDTO);
        return productRepository.save(product);
    }

    @Transactional
    public Product updateProductById(String id,RequestProductDTO requestProductDTO){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();

            product.setName(requestProductDTO.name());
            product.setPrice_in_cents(requestProductDTO.price_in_cents());
            return product;
        }

        throw new EntityNotFoundException();

    }

    @Transactional
    public Product disableProductById(String id){
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            Product product = productOptional.get();


            product.setActive(false);
            return product;




        }

        throw new EntityNotFoundException();


    }

    @Transactional
    public Product activatedProductById(String id){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()){

            Product product = optionalProduct.get();


            product.setActive(true);
            return product;

        }

        throw new EntityNotFoundException();
    }

}
