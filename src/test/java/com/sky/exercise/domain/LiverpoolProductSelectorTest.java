package com.sky.exercise.domain;

import com.google.common.collect.Multimap;
import com.sky.exercise.api.Category;
import com.sky.exercise.api.Product;
import com.sky.exercise.api.ProductSelectorDecorator;
import com.sky.exercise.api.ProductSelector;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LiverpoolProductSelectorTest {

    private ProductSelector productSelector = new DefaultProductSelector();
    ProductSelectorDecorator liverpoolProductDecorator = new LiverpoolProductDecorator(productSelector);

    @Test
    public void shouldSelectDefaultProducts() {
        Multimap<Category, Product> selected = liverpoolProductDecorator.selectProducts();

        assertThat(selected.size()).isEqualTo(3);
        assertThat(selected.containsEntry(Category.SPORTS, new Product("Liverpool TV"))).isTrue();
        assertThat(selected.containsEntry(Category.NEWS, new Product("Sky News"))).isTrue();
        assertThat(selected.containsEntry(Category.NEWS, new Product("Sky Sports News"))).isTrue();
    }
}