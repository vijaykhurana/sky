package com.sky.exercise.domain;

import com.google.common.collect.Multimap;
import com.sky.exercise.api.Category;
import com.sky.exercise.api.Product;
import com.sky.exercise.api.ProductSelector;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultProductSelectorTest {

    ProductSelector defaultProductSelector = new DefaultProductSelector();

    @Test
    public void shouldSelectDefaultProducts() {
        Multimap<Category, Product> defaultProducts = defaultProductSelector.selectProducts();

        assertThat(defaultProducts.size()).isEqualTo(2);
        assertThat(defaultProducts.containsEntry(Category.NEWS, new Product("Sky News"))).isTrue();
        assertThat(defaultProducts.containsEntry(Category.NEWS, new Product("Sky Sports News"))).isTrue();
    }
}