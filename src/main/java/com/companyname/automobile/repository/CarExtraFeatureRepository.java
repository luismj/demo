package com.companyname.automobile.repository;

import com.companyname.automobile.models.CarExtraFeature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarExtraFeatureRepository extends CrudRepository<CarExtraFeature, Integer> {
    Optional<CarExtraFeature> findByCode(String code);
}
