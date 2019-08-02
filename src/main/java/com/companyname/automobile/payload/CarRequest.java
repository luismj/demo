package com.companyname.automobile.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class CarRequest {
    @NotBlank
    private String type;
    private List<String> features = new ArrayList<>();
}
