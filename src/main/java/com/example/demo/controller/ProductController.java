package com.example.demo.controller;

import com.example.demo.annotation.MethodStats;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.vo.DomainResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
public class ProductController {


    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    @MethodStats
    public Mono<DomainResponse<List<Product>>>  getProducts() {
        log.info("products");
        return productService.getProducts();
    }


    @GetMapping("/products/{productId}")
    @MethodStats
    public Mono<DomainResponse<Product>>  getProductsById(@PathVariable(name = "productId") Long productId) {
        log.info("product with id  "+productId);
        return productService.getProductById(productId);
    }



}