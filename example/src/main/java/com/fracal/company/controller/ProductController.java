package com.fracal.company.controller;

import com.fracal.company.model.Product;
import com.fracal.company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public void createProduct(@RequestBody Product product) {
        productService.create(product);
    }

    @PostMapping("/edit")
    public void editProduct(@RequestBody Product product) {
        productService.edit(product);
    }

    @GetMapping("/list")
    public List<Product> listProducts() {
        return productService.list().stream().filter(data -> data.active == '1')
                .collect(Collectors.toList());
    }

    @PostMapping("/search/{id}")
    public Product searchProduct(@PathVariable String id) {
        return productService.search(id).get();
    }

    @PostMapping("/search/name/{name}")
    public List<Product> searchProductName(@PathVariable String name) {
        return productService.list().stream().filter(
                data -> data.active == '1' && data.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @PostMapping("/search/category/{category}")
    public List<Product> searchProductCategory(@PathVariable String category) {
        return productService.list().stream().filter(
                        data -> data.active == '1' && data.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @PostMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.delete(id);
    }
}