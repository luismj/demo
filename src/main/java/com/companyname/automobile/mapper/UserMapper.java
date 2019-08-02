package com.companyname.automobile.mapper;

import com.companyname.automobile.models.User;
import com.companyname.automobile.payload.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);
}
