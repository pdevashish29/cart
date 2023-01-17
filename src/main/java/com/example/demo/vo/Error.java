package com.example.demo.vo;

import lombok.Data;

import java.util.List;

@Data
public class Error {

    private String code;
    private String message;
    private List<ErrorDetails> errorDetails;
}
