package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Cart {

    private Long id;
    private Long userId;
    private Date date;
    private List<Item> products;
    @JsonProperty("_v")
    private Integer versino;

}
