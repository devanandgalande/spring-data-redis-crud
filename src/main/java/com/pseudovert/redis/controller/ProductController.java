package com.pseudovert.redis.controller;

import com.pseudovert.redis.entity.Product;
import com.pseudovert.redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@EnableCaching
public class ProductController {

    @Autowired
    private ProductDao dao;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return dao.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
    public Product findProductById(@PathVariable int id) {
        return dao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = "Product")
    public String deleteProduct(@PathVariable int id) {
        return dao.deleteProduct(id);
    }

}
