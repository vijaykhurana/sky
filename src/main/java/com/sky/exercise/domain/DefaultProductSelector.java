package com.sky.exercise.domain;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.sky.exercise.api.Category;
import com.sky.exercise.api.Product;
import com.sky.exercise.api.ProductSelector;

/**
 * Used to select the products that are available to everyone regardless of location
 */
public class DefaultProductSelector implements ProductSelector {

    public Multimap<Category, Product> selectProducts() {
        Multimap<Category, Product> selectedProducts = ArrayListMultimap.create();
        Product skyNews = new Product("Sky News");
        selectedProducts.put(Category.NEWS, skyNews);

        Product skySportsNews = new Product("Sky Sports News");
        selectedProducts.put(Category.NEWS, skySportsNews);

        return selectedProducts;
    }
}
