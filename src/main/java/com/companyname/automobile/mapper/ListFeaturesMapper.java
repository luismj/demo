package com.companyname.automobile.mapper;

import com.companyname.automobile.models.Car;
import com.companyname.automobile.models.CarExtraFeature;
import com.companyname.automobile.payload.CarResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ListFeaturesMapper {
    public List<String> toListCodes(Set<CarExtraFeature> features) {
        return features.stream()
                .map(CarExtraFeature::getCode)
                .collect(Collectors.toList());
    }
}
