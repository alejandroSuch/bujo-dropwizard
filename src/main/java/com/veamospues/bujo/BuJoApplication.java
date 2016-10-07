package com.veamospues.bujo;

import com.veamospues.bujo.resources.SaluteResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BuJoApplication extends Application<BuJoConfiguration> {

  public static void main(final String[] args) throws Exception {
    new BuJoApplication().run(args);
  }

  @Override
  public String getName() {
    return "BuJo";
  }

  @Override
  public void initialize(final Bootstrap<BuJoConfiguration> bootstrap) {
    // TODO: application initialization
  }

  @Override
  public void run(final BuJoConfiguration configuration, final Environment environment) {
    registerResources(configuration, environment);
    registerHealthChecks(configuration, environment);

  }

  private void registerHealthChecks(BuJoConfiguration configuration, Environment environment) {
    // TODO: register healthckecks here
  }

  private void registerResources(BuJoConfiguration configuration, Environment environment) {
    SaluteResource saluteResource = new SaluteResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
    );

    environment.jersey().register(saluteResource);
  }

}
