package com.sky.exercise.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.sky.exercise.api.Category;
import com.sky.exercise.domain.LondonProductDecorator;
import com.sky.exercise.api.Product;
import com.sky.exercise.api.ProductSelector;
import com.sky.exercise.domain.DefaultProductSelector;
import com.sky.exercise.domain.LiverpoolProductDecorator;
import com.sky.exercise.domain.Location;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Retrieves the selected products for each location using a domain service call
 */
public class CatalogueService {

    public Multimap<Category, Product> selectProductsForLocation(Location location) {
        checkNotNull(location);
        Multimap<Category, Product> selected = ArrayListMultimap.create();
        ProductSelector defaultProductSelector = new DefaultProductSelector();

        if (location == Location.LONDON) {
            selected = ImmutableMultimap.copyOf(new LondonProductDecorator(defaultProductSelector).selectProducts());
        } else if (location == Location.LIVERPOOL) {
            selected =  ImmutableMultimap.copyOf(new LiverpoolProductDecorator(defaultProductSelector).selectProducts());
        }

        return selected;
    }
}
