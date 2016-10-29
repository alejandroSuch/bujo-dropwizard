package com.veamospues.bujo.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.veamospues.bujo.api.dao.BulletDao;
import com.veamospues.bujo.api.domain.Bullet;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by alejandro on 17/10/16.
 */
@Singleton
@Path("/bullets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BulletResource {
  @Inject
  BulletDao bulletDao;

  @GET
  public List<Bullet> getBullets(@QueryParam("date") Optional<Date> date) {
    final List<Bullet> result = bulletDao.findByDate(date);

    if (result == null || result.isEmpty()) {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    return result;
  }

  @GET
  @Path("/{uuid}")
  public Bullet getBullet(@PathParam("uuid") UUID uuid) {
    final Bullet result = bulletDao.findById(uuid);

    if (result == null) {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    return result;
  }

  @DELETE
  @Path("/{uuid}")
  public void deleteBullet(@PathParam("uuid") UUID uuid) {
    final Bullet bullet = bulletDao.findById(uuid);

    if (bullet == null) {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    try {
      bulletDao.delete(bullet);
    } catch (Exception e) {
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }

    //Just in case void does not return a 204 response -->return Response.noContent().build();
  }
}
