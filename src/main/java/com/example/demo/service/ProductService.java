package com.example.demo.service;

import com.example.demo.exception.DomainException;
import com.example.demo.model.Product;
import com.example.demo.vo.DomainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    WebClient webClient;


    public Mono<DomainResponse<List<Product>>> getProducts(){
        var domainResponse = new DomainResponse<List<Product>>();
       return webClient.get().uri("/products").retrieve()
               .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("API not found")))
               .onStatus(HttpStatus::is5xxServerError, error -> Mono.error(new RuntimeException("Server is not responding")))
               .bodyToMono(new ParameterizedTypeReference<List<Product>>() {})
               .flatMap(item -> {
                    domainResponse.setData(item);
                    return Mono.just(domainResponse);
               }).onErrorResume(error ->  Mono.error(new DomainException("Not reachable to server at this time ")));

    }

    public Mono<DomainResponse<Product>> getProductById(Long productId){
        String path="/products/"+productId;
        var response= webClient.get().uri(path).retrieve().bodyToMono(Product.class);
        var domainResponse = new DomainResponse<Product>();
        return response.flatMap(item -> {
            domainResponse.setData(item);
            return Mono.just(domainResponse);
        });
    }



}
