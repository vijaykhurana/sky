package com.sky.exercise.domain;

import com.google.common.collect.Multimap;
import com.sky.exercise.api.Category;
import com.sky.exercise.api.Product;
import com.sky.exercise.api.ProductSelectorDecorator;
import com.sky.exercise.api.ProductSelector;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LondonProductSelectorTest {

    private ProductSelector productSelector = new DefaultProductSelector();
    ProductSelectorDecorator londonProductDecorator = new LondonProductDecorator(productSelector);

    @Test
    public void shouldSelectDefaultProducts() {
        Multimap<Category, Product> selected = londonProductDecorator.selectProducts();

        assertThat(selected.size()).isEqualTo(4);
        assertThat(selected.containsEntry(Category.SPORTS, new Product("Arsenal TV"))).isTrue();
        assertThat(selected.containsEntry(Category.SPORTS, new Product("Chelsea TV"))).isTrue();
        assertThat(selected.containsEntry(Category.NEWS, new Product("Sky News"))).isTrue();
        assertThat(selected.containsEntry(Category.NEWS, new Product("Sky Sports News"))).isTrue();
    }
}