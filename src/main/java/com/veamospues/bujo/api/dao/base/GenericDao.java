package com.veamospues.bujo.api.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alejandro on 11/10/16.
 */
public interface GenericDao<T, K extends Serializable> {
  public List<T> findAll();

  public T findById(K id);

  public T save(T entity);

  public void delete(T entity);
}
