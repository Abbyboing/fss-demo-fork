package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @CacheEvict(value = "products", allEntries = true)
    @Transactional
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Cacheable(value = "products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    @CacheEvict(value = "products", allEntries = true)
    @Transactional
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    @CacheEvict(value = "products", allEntries = true)
    @Transactional
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}
