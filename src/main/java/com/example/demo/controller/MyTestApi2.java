package com.example.demo.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@RestController
public class MyTestApi2 {


    @GetMapping("/test-premuture")
    public Mono<String> getIndex(){
        WebClient webClient = WebClient.create("http://localhost:9090/");
        return webClient.get().uri("test").retrieve().bodyToMono(String.class);

    }

    @GetMapping("/test-premuture-2")
    public String getIndex2(){
        RestTemplate restTemplate = new RestTemplate();
        String string = restTemplate.getForObject("http://localhost:9090/test", String.class);
        System.out.println(string);
        return  string;
    }

}
