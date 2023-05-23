package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;
import com.example.demo.vo.DomainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("carts")
    public Mono<DomainResponse<List<Cart>>> getCarts(@RequestParam(name= "userId", required = false) Long userId){

      try{
          return cartService.getCart();
      }catch (Exception e){
          System.out.println(e.getCause());
          return  Mono.error(e);
      }
    }

    @GetMapping("carts/{cartId}")
    public Mono<DomainResponse<Cart>> getCartById(@RequestParam(name= "userId", required = false) Long userId,@PathVariable(name= "cartId", required = false) Long cartId){
        try{
            return cartService.getCartsById(cartId);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  Mono.error(e);
        }
    }
}
