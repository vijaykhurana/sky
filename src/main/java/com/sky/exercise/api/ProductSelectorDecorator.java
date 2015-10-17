package com.sky.exercise.api;

import com.google.common.collect.Multimap;

public abstract class ProductSelectorDecorator implements ProductSelector {
    private ProductSelector productSelector;

    public ProductSelectorDecorator(ProductSelector productSelector) {
        this.productSelector = productSelector;
    }

    public Multimap<Category, Product> selectProducts() {
        return productSelector.selectProducts();
    }
}
