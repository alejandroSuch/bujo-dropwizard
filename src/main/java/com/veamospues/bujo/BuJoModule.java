package com.veamospues.bujo;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.veamospues.bujo.api.dao.BulletDao;
import com.veamospues.bujo.api.dao.EventDao;
import com.veamospues.bujo.api.dao.NoteDao;
import com.veamospues.bujo.api.dao.TaskDao;
import com.veamospues.bujo.api.dao.impl.BulletDaoImpl;
import com.veamospues.bujo.api.dao.impl.EventDaoImpl;
import com.veamospues.bujo.api.dao.impl.NoteDaoImpl;
import com.veamospues.bujo.api.dao.impl.TaskDaoImpl;
import com.veamospues.bujo.resources.SaluteResource;

import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

/**
 * Created by alejandro on 9/10/16.
 */
public class BuJoModule extends AbstractModule {

  public BuJoModule() {
  }

  @Provides
  @Singleton
  public JPAQueryFactory getJPAQueryFactory(Provider<EntityManager> entityManager) {
    return new JPAQueryFactory(entityManager);
  }

  @Override
  protected void configure() {
    bindDaos();
    bindResources();
  }

  private void bindDaos() {
    bind(NoteDao.class).to(NoteDaoImpl.class);
    bind(EventDao.class).to(EventDaoImpl.class);
    bind(TaskDao.class).to(TaskDaoImpl.class);
    bind(BulletDao.class).to(BulletDaoImpl.class);
  }

  private void bindResources() {
    bind(SaluteResource.class);
  }
}
