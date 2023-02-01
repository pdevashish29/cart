package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarchController {


    @GetMapping("/march")
    public  String getIndex(){
        return  "March";
    }

    @GetMapping("/march-2")
    public  String getIndex2(){
        return  "March-2";
    }
}
