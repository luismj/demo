package com.companyname.automobile.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "features")
public class CarExtraFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String code;
    private double price;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "features")
    @JsonBackReference
    private Set<Car> cars = new HashSet<>();
}
