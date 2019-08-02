package com.companyname.automobile.mapper;

import com.companyname.automobile.models.CarBodyStyle;
import com.companyname.automobile.models.CarExtraFeature;
import com.companyname.automobile.payload.FeaturesResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeaturesMapper {
    FeaturesResponse toFeatureResponse(CarExtraFeature feature);
    FeaturesResponse toFeatureResponse(CarBodyStyle type);
    List<FeaturesResponse> toFeatureList(List<CarExtraFeature> features);
    List<FeaturesResponse> toTypesList(List<CarBodyStyle> types);
    CarBodyStyle toCarBodyStyle(FeaturesResponse response);
    CarExtraFeature toCarExtraFeature(FeaturesResponse response);
}
