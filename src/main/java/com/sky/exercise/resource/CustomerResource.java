package com.sky.exercise.resource;

import com.sky.exercise.api.Category;
import com.sky.exercise.api.Product;
import com.sky.exercise.domain.Location;
import com.sky.exercise.service.CatalogueService;
import com.sky.exercise.service.CustomerLocationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Map;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private final CatalogueService catalogueService;
    private final CustomerLocationService customerLocationService;

    public CustomerResource(CatalogueService catalogueService, CustomerLocationService customerLocationService) {
        this.catalogueService = catalogueService;
        this.customerLocationService = customerLocationService;
    }

    @GET
    @Path("/{customerId}/products")
    public Map<Category, Collection<Product>> getProductsForCustomer(@PathParam("customerId") Long customerId) {
        Location customerLocation = customerLocationService.getCustomerLocation(customerId);

        return catalogueService.selectProductsForLocation(customerLocation).asMap();
    }
}
