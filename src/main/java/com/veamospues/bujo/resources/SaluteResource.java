package com.veamospues.bujo.resources;

import com.codahale.metrics.annotation.Timed;
import com.veamospues.bujo.api.SaluteResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alejandro on 7/10/16.
 */
@Path("/salute")
@Produces(MediaType.APPLICATION_JSON)
public class SaluteResource {
  private String template;
  private String defaultName;

  private AtomicLong counter;

  public SaluteResource(String template, String defaultName) {
    this.template = template;
    this.defaultName = defaultName;
    this.counter = new AtomicLong();
  }

  @GET
  @Timed
  public SaluteResponse sayHello(@QueryParam("name") Optional<String> name) {
    return new SaluteResponse(
            counter.incrementAndGet(),
            String.format(template, name.orElse(defaultName))
    );
  }
}
