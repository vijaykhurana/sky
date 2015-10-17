package com.sky.exercise.service;

import com.google.common.collect.Multimap;
import com.sky.exercise.api.Category;
import com.sky.exercise.domain.Location;
import com.sky.exercise.api.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class CatalogueServiceTest {

    private final CatalogueService catalogueService = new CatalogueService();

    @Rule
    public ExpectedException thrownException = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenPassingNullLocation() {
        thrownException.expect(NullPointerException.class);

        catalogueService.selectProductsForLocation(null);
    }

    @Test
    public void shouldThrowExceptionWhenModifyingLondonSelectedProducts() {
        thrownException.expect(UnsupportedOperationException.class);

        Multimap<Category, Product> selectedProducts = catalogueService.selectProductsForLocation(Location.LONDON);

        selectedProducts.put(Category.SPORTS, new Product("Sheffield United TV"));
    }

    @Test
    public void shouldThrowExceptionWhenModifyingSelectedProducts() {
        thrownException.expect(UnsupportedOperationException.class);

        Multimap<Category, Product> selectedProducts = catalogueService.selectProductsForLocation(Location.LIVERPOOL);

        selectedProducts.put(Category.SPORTS, new Product("Sheffield United TV"));
    }

    @Test
    public void shouldSelectProductsForLondon() {
        Multimap<Category, Product> selectedProducts = catalogueService.selectProductsForLocation(Location.LONDON);

        assertThat(selectedProducts.size()).isEqualTo(4);

        assertThat(selectedProducts.get(Category.SPORTS).size()).isEqualTo(2);
        assertThat(selectedProducts.get(Category.SPORTS).contains(new Product("Arsenal TV"))).isTrue();
        assertThat(selectedProducts.get(Category.SPORTS).contains(new Product("Chelsea TV"))).isTrue();

        assertDefaultProductsAreSelected(selectedProducts);
    }

    @Test
    public void shouldSelectProductsForLiverpool() {
        Multimap<Category, Product> selectedProducts = catalogueService.selectProductsForLocation(Location.LIVERPOOL);

        assertThat(selectedProducts.size()).isEqualTo(3);

        assertThat(selectedProducts.get(Category.SPORTS).size()).isEqualTo(1);
        assertThat(selectedProducts.get(Category.SPORTS).contains(new Product("Liverpool TV"))).isTrue();

        assertDefaultProductsAreSelected(selectedProducts);
    }

    private void assertDefaultProductsAreSelected(Multimap<Category, Product> selectedProducts) {
        assertThat(selectedProducts.get(Category.NEWS).size()).isEqualTo(2);
        assertThat(selectedProducts.get(Category.NEWS).contains(new Product("Sky News"))).isTrue();
        assertThat(selectedProducts.get(Category.NEWS).contains(new Product("Sky Sports News"))).isTrue();
    }
}