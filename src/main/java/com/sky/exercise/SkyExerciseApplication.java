package com.sky.exercise;

import com.sky.exercise.configuration.SkyExerciseConfiguration;
import com.sky.exercise.resource.CustomerResource;
import com.sky.exercise.service.CatalogueService;
import com.sky.exercise.service.CustomerLocationService;
import com.sky.exercise.service.CustomerLocationServiceStub;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Main class which runs the sky exercise application
 */
public class SkyExerciseApplication extends Application<SkyExerciseConfiguration> {

    @Override
    public void run(SkyExerciseConfiguration config, Environment environment) throws Exception {
        CatalogueService catalogueService = new CatalogueService();
        CustomerLocationService customerLocationService = new CustomerLocationServiceStub();

        final CustomerResource resource = new CustomerResource(catalogueService, customerLocationService);
        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(resource);
    }

    public static void main(String... args) throws Exception {
        new SkyExerciseApplication().run(new String[]{"server", "sky-exercise.yml"});
    }

    @Override
    public void initialize(Bootstrap<SkyExerciseConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }
}