package com.example.demo.model;

import lombok.Data;

@Data
public class Address {
    private String city;
    private String street;
    private Long number;
    private String zipcode;
    private Geolocation geolocation;

}
