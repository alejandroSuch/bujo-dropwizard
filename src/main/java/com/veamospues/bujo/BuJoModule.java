package com.veamospues.bujo;

import com.google.inject.AbstractModule;
import com.veamospues.bujo.api.dao.BulletDao;
import com.veamospues.bujo.api.dao.TaskDao;
import com.veamospues.bujo.api.dao.impl.BulletDaoImpl;
import com.veamospues.bujo.api.dao.impl.TaskDaoImpl;
import com.veamospues.bujo.resources.SaluteResource;

/**
 * Created by alejandro on 9/10/16.
 */
public class BuJoModule extends AbstractModule {

  public BuJoModule() {
  }

  @Override
  protected void configure() {
    bindDaos();
    bindResources();
  }

  private void bindDaos() {
    bind(TaskDao.class).to(TaskDaoImpl.class);
    bind(BulletDao.class).to(BulletDaoImpl.class);
  }

  private void bindResources() {
    bind(SaluteResource.class);
  }
}
