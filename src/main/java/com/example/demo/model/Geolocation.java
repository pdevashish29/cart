package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Geolocation {

    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("long")
    private String longitude;



}
