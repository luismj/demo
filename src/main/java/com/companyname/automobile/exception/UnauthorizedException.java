package com.companyname.automobile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
    private String email;
    private Integer resourceId;

    public UnauthorizedException(String email, Integer resourceId) {
        super(String.format("%s is unauthorized to access resource %s", email, resourceId));
        this.email = email;
        this.resourceId = resourceId;
    }
}
