package com.kriNad.backend.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Customer with id " + id + " not found");
    }
}
