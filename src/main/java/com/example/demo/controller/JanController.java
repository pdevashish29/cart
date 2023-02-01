package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JanController {


    @GetMapping("/jan")
    public String getIndex(){
        return "Jan";
    }
}
