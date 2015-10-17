package com.sky.exercise.domain;

import com.google.common.collect.Multimap;
import com.sky.exercise.api.Category;
import com.sky.exercise.api.Product;
import com.sky.exercise.api.ProductSelector;
import com.sky.exercise.api.ProductSelectorDecorator;

public class LondonProductDecorator extends
        ProductSelectorDecorator {

    public LondonProductDecorator(ProductSelector productSelector) {
        super(productSelector);
    }

    public Multimap<Category, Product> selectProducts() {
        Multimap<Category, Product> selected = super.selectProducts();

        Product arsenalTV = new Product("Arsenal TV");
        selected.put(Category.SPORTS, arsenalTV);

        Product chelseaTV = new Product("Chelsea TV");
        selected.put(Category.SPORTS, chelseaTV);

        return selected;
    }
}
