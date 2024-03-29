package com.ostap.hotels.utils;

import com.ostap.hotels.repository.CustomerDAO;
import com.ostap.hotels.models.Customer;
import com.ostap.hotels.controllers.ValidationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Customer.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;
        if (customer.getUsername().length() < 4) {
            errors.rejectValue("username", "message.length.error");
        }

        if (customer.getPassword().length() < 6) {
            errors.rejectValue("password", "password.lenght.error");
        }

        if (ValidationController.usernamevalidation(customerDAO, customer.getUsername())) {
            errors.rejectValue("username", "username.ae.error");

        }
        if (ValidationController.emailvalidation(customerDAO, customer.getEmail())) {
            errors.rejectValue("email", "email.ae.error");
        }

    }

}
