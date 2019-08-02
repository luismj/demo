package com.companyname.automobile.payload;

import lombok.Data;

import java.util.List;

@Data
public class CarResponse {
    private Integer id;
    private String description;
    private double total;
    private List<String> optionals;
}
