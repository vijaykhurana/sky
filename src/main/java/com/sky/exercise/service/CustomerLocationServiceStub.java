package com.sky.exercise.service;

import com.sky.exercise.domain.Location;
import com.sky.exercise.service.exception.InvalidCustomerException;

/**
 * Stubs the getCustomerLocation method.
 * Customer id 1l returns London
 * Customer id 2l returns Liverpool locationId
 * Otherwise throws a runtime exception
 */
public class CustomerLocationServiceStub implements CustomerLocationService {

    public Location getCustomerLocation(Long customerId) {
        if (customerId == 1l) {
            return Location.LONDON;
        } else if (customerId == 2l) {
            return Location.LIVERPOOL;
        }

        throw new InvalidCustomerException(customerId + " is not a valid customer.");
    }
}
