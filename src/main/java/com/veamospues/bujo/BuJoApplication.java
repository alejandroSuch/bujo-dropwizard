package com.veamospues.bujo;

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
    public void run(final BuJoConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
