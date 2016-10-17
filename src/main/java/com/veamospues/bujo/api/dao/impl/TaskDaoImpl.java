package com.veamospues.bujo.api.dao.impl;

import com.google.inject.persist.Transactional;
import com.veamospues.bujo.api.dao.TaskDao;
import com.veamospues.bujo.api.dao.base.GenericAbstractDao;
import com.veamospues.bujo.api.domain.Task;

import javax.inject.Singleton;
import java.util.UUID;

/**
 * Created by alejandro on 11/10/16.
 */
@Transactional
@Singleton
public class TaskDaoImpl extends GenericAbstractDao<Task, UUID> implements TaskDao {
  public TaskDaoImpl() {
    super(Task.class);
  }
}
