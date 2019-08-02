package com.companyname.automobile.mapper;

import com.companyname.automobile.models.Car;
import com.companyname.automobile.models.CarExtraFeature;
import com.companyname.automobile.payload.CarResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = {ListFeaturesMapper.class},componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CarMapper {
    @Mappings({
            @Mapping(target = "description", source = "style.description"),
            @Mapping(target = "optionals", source="features")
    })
    CarResponse toCarResponse(Car car);

   // List<CarResponse> toCarResponseList(List<Car> cars);
}
