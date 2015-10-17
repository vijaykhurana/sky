package com.sky.exercise.resource;

import com.google.common.collect.ArrayListMultimap;
import com.sky.exercise.api.Category;
import com.sky.exercise.domain.Location;
import com.sky.exercise.api.Product;
import com.sky.exercise.service.CatalogueService;
import com.sky.exercise.service.CustomerLocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerResourceTest {

    @Mock
    private CatalogueService catalogueService;

    @Mock
    private CustomerLocationService customerLocationService;

    @InjectMocks
    CustomerResource resource;

    @Test
    public void testGetProductsForCustomer() {
        Long customerId = 1l;
        when(customerLocationService.getCustomerLocation(customerId)).thenReturn(Location.LONDON);
        when(catalogueService.selectProductsForLocation(Location.LONDON)).thenReturn(ArrayListMultimap.<Category, Product>create());

        resource.getProductsForCustomer(customerId);

        verify(customerLocationService).getCustomerLocation(customerId);
        verify(catalogueService).selectProductsForLocation(Location.LONDON);
    }
}