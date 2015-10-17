package com.sky.exercise.service;

import com.sky.exercise.domain.Location;
import com.sky.exercise.service.exception.InvalidCustomerException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerLocationServiceStubTest {
    private CustomerLocationServiceStub customerLocationServiceStub = new CustomerLocationServiceStub();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetCustomerLocation_ThrowsException() {
        expectedException.expect(InvalidCustomerException.class);

        Long invalidCustomerId = -1l;
        customerLocationServiceStub.getCustomerLocation(invalidCustomerId);
    }

    @Test
    public void testGetCustomerLocation_London() {

        Long londonCustomerId = 1l;
        Location customerLocation = customerLocationServiceStub.getCustomerLocation(londonCustomerId);

        assertThat(customerLocation).isEqualTo(Location.LONDON);
    }

    @Test
    public void testGetCustomerLocation_Liverpool() {

        Long liverpoolCustomerId = 2l;
        Location customerLocation = customerLocationServiceStub.getCustomerLocation(liverpoolCustomerId);

        assertThat(customerLocation).isEqualTo(Location.LIVERPOOL);
    }

}