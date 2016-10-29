package com.veamospues.bujo;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.veamospues.bujo.resources.SaluteResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class BuJoApplication extends Application<BuJoConfiguration> {
  private Injector injector;

  public static void main(final String[] args) throws Exception {
    new BuJoApplication().run(args);
  }

  @Override
  public String getName() {
    return "BuJo";
  }

  @Override
  public void initialize(final Bootstrap<BuJoConfiguration> bootstrap) {

  }

  @Override
  public void run(final BuJoConfiguration configuration, final Environment environment) {
    injector = Guice.createInjector(
            new JpaPersistModule("com.veamospues.bujo.pu"),
            new BuJoModule()
    );

    // injector.getInstance(PersistService.class).start();

    registerFilters(configuration, environment);
    registerHealthChecks(configuration, environment);
    registerResources(configuration, environment);
  }

  private void registerFilters(BuJoConfiguration configuration, Environment environment) {
    environment
            .servlets()
            .addFilter("persistFilter", injector.getInstance(PersistFilter.class))
            .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
  }

  private void registerHealthChecks(BuJoConfiguration configuration, Environment environment) {
    // TODO: register healthckecks here
  }

  private void registerResources(BuJoConfiguration configuration, Environment environment) {
    environment.jersey().register(injector.getInstance(SaluteResource.class));
  }

}
