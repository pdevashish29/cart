package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String city;
    private String street;
    private Long number;
    private String zipcode;
    private Geolocation geolocation;

}
