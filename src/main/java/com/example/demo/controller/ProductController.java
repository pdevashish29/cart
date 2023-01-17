package com.example.demo.controller;

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
    public Mono<DomainResponse<List<Product>>>  getProducts() {
        log.info("products");
        long t1 = System.currentTimeMillis();
        var response= productService.getProducts();
        long t2 = System.currentTimeMillis();
        log.info(t2-t1+"");
        return  response;
    }


    @GetMapping("/products/{productId}")
    public Mono<DomainResponse<Product>>  getProductsById(@PathVariable(name = "productId") Long productId) {
        log.info("product with id  "+productId);
        long t1 = System.currentTimeMillis();
        var response= productService.getProductById(productId);
        long t2 = System.currentTimeMillis();
        log.info(t2-t1+"");
        return  response;
    }



}