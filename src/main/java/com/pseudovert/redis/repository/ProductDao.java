package com.pseudovert.redis.repository;

import com.pseudovert.redis.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class ProductDao {
    @Autowired
    private RedisTemplate redisTemplate;

    public static final String HASH_KEY = "Product";

    public Product save(Product product){
        redisTemplate.opsForHash().put( HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id){
        log.info("Fetching data from DB, id: {}", id);
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProduct(int id){
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "Product removed successfully!";
    }

}


