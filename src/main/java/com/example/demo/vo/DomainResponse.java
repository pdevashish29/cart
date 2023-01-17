package com.example.demo.vo;

import lombok.Data;

@Data
public class DomainResponse<T> {

    private T data;
    private Error error;
}
