package com.companyname.automobile.controller;

import com.companyname.automobile.mapper.UserMapper;
import com.companyname.automobile.payload.UserResponse;
import com.companyname.automobile.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private UserMapper mapper;

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(mapper.toUserResponse(service.getByUsername(username)));
    }
}
