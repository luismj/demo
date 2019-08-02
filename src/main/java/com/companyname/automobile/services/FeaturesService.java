package com.companyname.automobile.services;

import com.companyname.automobile.models.CarBodyStyle;
import com.companyname.automobile.models.CarExtraFeature;
import com.companyname.automobile.repository.CarBodyStyleRepository;
import com.companyname.automobile.repository.CarExtraFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FeaturesService {
    @Autowired
    private CarExtraFeatureRepository featuresRepository;
    @Autowired
    private CarBodyStyleRepository typesRepository;

    public List<CarBodyStyle> findAllTypesCar() {
        return StreamSupport
                .stream(typesRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<CarExtraFeature> findAllFeatures() {
        return StreamSupport
                .stream(featuresRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
