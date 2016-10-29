package com.veamospues.bujo.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.veamospues.bujo.api.dao.BulletDao;
import com.veamospues.bujo.api.dao.EventDao;
import com.veamospues.bujo.api.dao.TaskDao;
import com.veamospues.bujo.api.dao.impl.BulletDaoImpl;
import com.veamospues.bujo.api.domain.Bullet;
import com.veamospues.bujo.api.domain.Event;
import com.veamospues.bujo.api.domain.Task;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alejandro on 7/10/16.
 */
@Singleton
@Path("/salute")
@Produces(MediaType.APPLICATION_JSON)
public class SaluteResource {
  private String template = "Hello, %s";
  private String defaultName = "world";

  private AtomicLong counter;

  @Inject
  TaskDao taskDao;

  @Inject
  EventDao eventDao;

  @Inject
  BulletDao bulletDao;


  public SaluteResource() {
    this.counter = new AtomicLong();
  }

  @GET
  @Timed
  public List<Bullet> sayHello(@QueryParam("name") Optional<String> name) {
    Task task = new Task();
    task.setTitle("ir al WC");

    Event event = new Event();
    event.setTitle("Visita de la reina");

    Task savedTask = taskDao.save(task);
    savedTask = taskDao.save(task);
    Event savedEvent = eventDao.save(event);
    savedTask = taskDao.save(task);
    savedEvent = eventDao.save(event);
    savedTask = taskDao.save(task);
    savedEvent = eventDao.save(event);
    savedTask = taskDao.save(task);
    savedEvent = eventDao.save(event);

    final Task taskDaoById = taskDao.findById(savedTask.getUuid());

    return bulletDao.findByDate(Optional.of(new Date()));
  }
}
