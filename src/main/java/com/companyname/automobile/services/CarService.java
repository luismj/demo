package com.companyname.automobile.services;

import com.companyname.automobile.demo.security.UserPrincipal;
import com.companyname.automobile.exception.ResourceNotFoundException;
import com.companyname.automobile.models.Car;
import com.companyname.automobile.models.CarExtraFeature;
import com.companyname.automobile.payload.CarRequest;
import com.companyname.automobile.repository.CarBodyStyleRepository;
import com.companyname.automobile.repository.CarExtraFeatureRepository;
import com.companyname.automobile.repository.CarRepository;
import com.companyname.automobile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;
    @Autowired
    private CarExtraFeatureRepository featureRepository;
    @Autowired
    private CarBodyStyleRepository typeRepository;
    @Autowired
    private UserRepository userRepository;

    public void deleteCar(Integer id) {
        repository.deleteById(id);
    }

    public Car createCar(CarRequest request, UserPrincipal currentUser) {
        Car car = new Car();
        car.setStyle(typeRepository.findByDescription(request.getType())
                .orElseThrow(() -> new ResourceNotFoundException("Type", "description", request.getType())));
        double subtotal = 0.0;

        if(!request.getFeatures().isEmpty()) {
            car.setFeatures(request.getFeatures()
                    .stream()
                    .map((String temp) ->
                            featureRepository.findByCode(temp)
                                    .orElseThrow(() -> new ResourceNotFoundException("Feature", "code", temp)))
                    .collect(Collectors.toSet()));
            subtotal = car.getFeatures().stream().map(CarExtraFeature::getPrice).mapToDouble(Double::doubleValue).sum();
        }

        car.setTotal(subtotal + car.getStyle().getPrice());
        car.setUser(userRepository.findById(currentUser.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", currentUser.getId())));
        return repository.save(car);
    }

    public List<Car> findAll(UserPrincipal currentUser) {
        List<Car> cars = repository.findByUserId(currentUser.getId());
        return cars;
    }

    public Car findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
    }
}
