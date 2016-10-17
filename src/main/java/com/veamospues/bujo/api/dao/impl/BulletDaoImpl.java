package com.veamospues.bujo.api.dao.impl;

import com.google.inject.persist.Transactional;
import com.veamospues.bujo.api.dao.BulletDao;
import com.veamospues.bujo.api.dao.base.GenericAbstractDao;
import com.veamospues.bujo.api.domain.Bullet;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import java.util.UUID;

/**
 * Created by alejandro on 11/10/16.
 */
@Transactional
@Singleton
public class BulletDaoImpl extends GenericAbstractDao<Bullet, UUID> implements BulletDao {
  public BulletDaoImpl() {
    super(Bullet.class);
  }
}
