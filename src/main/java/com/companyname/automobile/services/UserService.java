package com.companyname.automobile.services;

import com.companyname.automobile.exception.ResourceNotFoundException;
import com.companyname.automobile.models.User;
import com.companyname.automobile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }
}
