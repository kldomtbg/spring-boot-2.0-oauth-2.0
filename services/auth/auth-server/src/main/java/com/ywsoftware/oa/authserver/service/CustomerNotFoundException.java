package com.ywsoftware.oa.authserver.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(String message) {
        super(message);
    }
}
