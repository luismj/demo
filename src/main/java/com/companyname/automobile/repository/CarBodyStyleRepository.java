package com.companyname.automobile.repository;

import com.companyname.automobile.models.CarBodyStyle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarBodyStyleRepository extends CrudRepository<CarBodyStyle, Integer> {
    Optional<CarBodyStyle> findByDescription(String description);
}
