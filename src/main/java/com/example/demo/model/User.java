package com.example.demo.model;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private Name name;
    private Address address;
    private String phone;
    private Integer __v;

}
