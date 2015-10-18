package com.sky.exercise.domain;

import com.google.common.collect.Multimap;
import com.sky.exercise.api.Category;
import com.sky.exercise.api.Product;
import com.sky.exercise.api.ProductSelector;
import com.sky.exercise.api.ProductSelectorDecorator;

/**
 * Used to select the channel subscriptions available to Liverpool customers
 */
public class LiverpoolProductDecorator extends
        ProductSelectorDecorator {

    public LiverpoolProductDecorator(ProductSelector productSelector) {
        super(productSelector);
    }

    public Multimap<Category, Product> selectProducts() {
        Multimap<Category, Product> selected = super.selectProducts();

        Product liverpoolTV = new Product("Liverpool TV");
        selected.put(Category.SPORTS, liverpoolTV);

        return selected;
    }
}
