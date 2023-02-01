package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FebController {


    @GetMapping("?feb")
    public  String getIndex(){
        return  "Feb";
    }
}
