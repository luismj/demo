package com.companyname.automobile.controller;

import com.companyname.automobile.demo.security.UserPrincipal;
import com.companyname.automobile.demo.security.annotation.CurrentUser;
import com.companyname.automobile.mapper.CarMapper;
import com.companyname.automobile.mapper.FeaturesMapper;
import com.companyname.automobile.mapper.ListFeaturesMapper;
import com.companyname.automobile.models.Car;
import com.companyname.automobile.payload.CarRequest;
import com.companyname.automobile.payload.CarResponse;
import com.companyname.automobile.payload.FeaturesResponse;
import com.companyname.automobile.services.CarService;
import com.companyname.automobile.services.FeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    @Autowired
    private CarService service;
    @Autowired
    private FeaturesService featureService;
    @Autowired
    private FeaturesMapper featuresMapper;
    @Autowired
    private CarMapper carMapper;

    @GetMapping("/types")
    public ResponseEntity<List<FeaturesResponse>> findTypes() {
        return ResponseEntity.ok(featuresMapper.toTypesList(featureService.findAllTypesCar()));
    }

    @GetMapping("/features")
    public ResponseEntity<List<FeaturesResponse>> findFeatures() {
        return ResponseEntity.ok(featuresMapper.toFeatureList(featureService.findAllFeatures()));
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAll(@CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(service.findAll(currentUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CarResponse> createCar(@CurrentUser UserPrincipal currentUser,
                                                 @Valid @RequestBody CarRequest request) {
        Car car = service.createCar(request, currentUser);
        return ResponseEntity.ok(carMapper.toCarResponse(car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@CurrentUser UserPrincipal currentUser, @PathVariable Integer id) {
        service.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
