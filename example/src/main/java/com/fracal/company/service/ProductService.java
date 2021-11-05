package com.fracal.company.service;

import com.fracal.company.model.Product;
import com.fracal.company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void create(Product product) {
        productRepository.insert(product);
    }

    public void edit(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> search(String productId) {
        return productRepository.findById(productId);
    }

    public void delete(String productId) {
        productRepository.deleteById(productId);
    }

    public List<Product> list() {
        return productRepository.findAll();
    }
}