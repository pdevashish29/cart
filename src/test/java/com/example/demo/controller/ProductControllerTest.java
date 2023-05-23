package com.example.demo.controller;

import com.example.demo.service.ProductService;
import com.example.demo.vo.DomainResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    @Test
    void getProducts() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        var domainResponse= mapper.readValue(new File("src/test/resources/Products.json"), DomainResponse.class);
        Mockito.when(productService.getProducts()).thenReturn(Mono.just(domainResponse));
        StepVerifier.create(productController.getProducts(null)).consumeNextWith(item -> assertNotNull(item.getData())).verifyComplete();

    }

    @Test
    void getProductsById() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        var domainResponse= mapper.readValue(new File("src/test/resources/Product.json"), DomainResponse.class);
        Mockito.when(productService.getProductById(Mockito.anyLong())).thenReturn(Mono.just(domainResponse));
        StepVerifier.create(productController.getProductsById(Mockito.anyLong())).consumeNextWith(item -> assertNotNull(item.getData())).verifyComplete();

    }


}