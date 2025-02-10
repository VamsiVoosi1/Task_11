package com.example.task11.Service;

import com.example.task11.Entity.Product;
import com.example.task11.Respository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;
//Constructor Injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Save Product
    public void saveProduct(Product product){
        productRepository.save(product);
    }
    //View Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
