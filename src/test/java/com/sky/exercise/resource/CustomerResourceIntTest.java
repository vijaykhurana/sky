package com.sky.exercise.resource;

import com.sky.exercise.SkyExerciseApplication;
import com.sky.exercise.configuration.SkyExerciseConfiguration;
import com.sky.exercise.api.Category;
import com.sky.exercise.api.Product;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerResourceIntTest {
    @ClassRule
    public static final DropwizardAppRule<SkyExerciseConfiguration> RULE =
            new DropwizardAppRule<SkyExerciseConfiguration>(SkyExerciseApplication.class, ResourceHelpers.resourceFilePath("sky-exercise.yml"));

    private CustomerResource customerResource;
    private Client client;

    @Test
    public void testGetProductsForCustomer() throws Exception {
        client = new JerseyClientBuilder(RULE.getEnvironment()).using(RULE.getConfiguration().getJerseyClientConfiguration()).build("available bets client");
        Map<Category, Collection<Product>> availableCustomerProducts = client.target(
                String.format(RULE.getConfiguration().getLocalUrl() + ":%d/api/customer/1/products", RULE.getLocalPort())).request(MediaType.APPLICATION_JSON)
                .get(Map.class);

        assertThat(availableCustomerProducts.size()).isEqualTo(2);

        assertThat(availableCustomerProducts.containsKey(Category.NEWS.name())).isTrue();
        assertThat(availableCustomerProducts.get(Category.NEWS.name()).size()).isEqualTo(2);

        assertThat(availableCustomerProducts.containsKey(Category.SPORTS.name())).isTrue();
        assertThat(availableCustomerProducts.get(Category.SPORTS.name()).size()).isEqualTo(2);
    }
}
