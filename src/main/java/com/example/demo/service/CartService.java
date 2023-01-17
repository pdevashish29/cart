package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.vo.DomainResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class CartService {



    @Autowired
    WebClient webClient;


    public Mono<DomainResponse<List<Cart>>> getCart(){
        var response= webClient.get().uri("/carts").retrieve().bodyToMono(new ParameterizedTypeReference<List<Cart>>() {});
        var domainResponse = new DomainResponse<List<Cart>>();
        return response.flatMap(item -> {
            domainResponse.setData(item);
            return Mono.just(domainResponse);
        });
    }

    public Mono<DomainResponse<Cart>> getCartsById(Long cartId){
        String path="/carts/"+cartId;
        var response= webClient.get().uri(path).retrieve().bodyToMono(Cart.class);
        var domainResponse = new DomainResponse<Cart>();
        return response.flatMap(item -> {
            domainResponse.setData(item);
            return Mono.just(domainResponse);
        });
    }

}
