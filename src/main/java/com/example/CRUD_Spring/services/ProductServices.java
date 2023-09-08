package com.example.CRUD_Spring.services;

import com.example.CRUD_Spring.DTO.RequestProductDTO;
import com.example.CRUD_Spring.DTO.RequestUpdateProductDTO;
import com.example.CRUD_Spring.domain.product.Product;
import com.example.CRUD_Spring.exceptions.ProductNotFoundException;
import com.example.CRUD_Spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product addProduct(RequestProductDTO requestProductDTO){
        Product product = new Product(requestProductDTO);
        return productRepository.save(product);
    }

    public Product updateProductById(String id,RequestProductDTO requestProductDTO){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();

            product.setName(requestProductDTO.name());
            product.setPrice_in_cents(requestProductDTO.price_in_cents());

            productRepository.save(product);

            return product;
        }

        throw new ProductNotFoundException("Produto com o ID " + id + " não encontrado");

    }

    public String deleteProductById(String id){
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            productRepository.deleteById(id);
            return "Produto com o ID " + id + " foi deletado com sucesso";
        }

        throw new ProductNotFoundException("Produto com o ID " + id + " não encontrado");


    }

}
