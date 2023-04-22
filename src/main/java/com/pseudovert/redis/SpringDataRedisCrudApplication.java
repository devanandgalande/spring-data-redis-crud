package com.pseudovert.redis;

import com.pseudovert.redis.entity.Product;
import com.pseudovert.redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class SpringDataRedisCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisCrudApplication.class, args);
	}

}
