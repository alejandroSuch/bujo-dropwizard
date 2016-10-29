package com.veamospues.bujo.api.dao.base;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by alejandro on 11/10/16.
 */
public abstract class GenericAbstractDao<T, K extends Serializable> implements GenericDao<T, K> {
  @Inject
  public Provider<EntityManager> entityManagerProvider;

  @Inject
  protected JPAQueryFactory queryFactory;

  Class<T> persistentClass;

  public GenericAbstractDao(Class<T> clazz) {
    this.persistentClass = clazz;
    //this.entityManagerProvider = entityManagerProvider;
  }

  @Override
  public List<T> findAll() {
    return entityManager()
            .createQuery(
                    String.format("SELECT T FROM %s T", persistentClass.getSimpleName()),
                    persistentClass
            )
            .getResultList();

  }

  @Override
  public T findById(K id) {
    return entityManager().find(persistentClass, id);
  }

  @Override
  public T save(T entity) {
    if (isAlreadyPersisted(entity)) {
      return entityManager().merge(entity);
    } else {
      entityManager().persist(entity);
      return entity;
    }
  }

  public boolean isAlreadyPersisted(T entity) {
    return entityManager().contains(entity);
  }

  @Override
  public void delete(T entity) {
    entityManager().remove(entity);
  }

  public void deleteById(K id) {
    final T entity = this.findById(id);

    Preconditions
            .checkNotNull(
                    entity,
                    String.format("%s with id %s not found", persistentClass.getSimpleName(), id.toString())
            );

    this.delete(entity);
  }

  protected EntityManager entityManager() {
    return entityManagerProvider.get();
  }
}
