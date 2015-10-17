package com.sky.exercise.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void shouldSerializeToJSON() throws Exception {
        final Product product = new Product("a_product");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/A_Product.json"), Product.class));

        assertThat(MAPPER.writeValueAsString(product)).isEqualTo(expected);
    }

    @Test
    public void sameProductsShouldBeEqual() {
        final Product product = new Product("a_product");

        assertThat(product).isEqualTo(product);
    }

    @Test
    public void productsWithSameNamesShouldBeEqual() {
        final Product product = new Product("a_product");
        final Product equalProduct = new Product("a_product");

        assertThat(product).isEqualTo(equalProduct);
    }

    @Test
    public void productsWithDifferentNamesShouldNotBeEqual() {
        final Product product = new Product("a_product");
        final Product unequalProduct = new Product("another_product");

        assertThat(product).isNotEqualTo(unequalProduct);
    }

    @Test
    public void equalsObjectShouldHaveSameHash() {
        final Product product = new Product("a_product");
        final Product sameProduct = new Product("a_product");

        assertThat(product.hashCode()).isEqualTo(sameProduct.hashCode());
    }
}