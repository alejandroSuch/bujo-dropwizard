package com.veamospues.bujo.api.dao;

import com.veamospues.bujo.api.dao.base.GenericDao;
import com.veamospues.bujo.api.domain.Task;

import java.util.UUID;

/**
 * Created by alejandro on 11/10/16.
 */
public interface TaskDao extends GenericDao<Task, UUID> {
}
