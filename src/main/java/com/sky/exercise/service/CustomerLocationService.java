package com.sky.exercise.service;

import com.sky.exercise.domain.Location;

public interface CustomerLocationService {

    Location getCustomerLocation(Long customerId);
}
