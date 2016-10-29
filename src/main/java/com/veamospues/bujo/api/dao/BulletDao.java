package com.veamospues.bujo.api.dao;

import com.veamospues.bujo.api.dao.base.GenericDao;
import com.veamospues.bujo.api.domain.Bullet;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by alejandro on 11/10/16.
 */
public interface BulletDao extends GenericDao<Bullet, UUID> {
  public List<Bullet> findByDate(Optional<Date> date); //Daily Log
  public List<Bullet> findByMonth(Optional<Date> date); //Monthly Log
  public List<Bullet> findByDateGreaterThan(Optional<Date> date); //Future Log
}
