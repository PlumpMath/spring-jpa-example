package com.fasfsfgs.example.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDAO<D> {

  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  protected final Class<D> getEntityClass() {
    ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
    return (Class<D>) (superclass).getActualTypeArguments()[0];
  }

  public List<D> getAll() {
    CriteriaQuery<D> criteriaQuery =
        entityManager.getCriteriaBuilder().createQuery(getEntityClass());
    criteriaQuery.from(getEntityClass());

    return entityManager.createQuery(criteriaQuery).getResultList();
  }

  public void save(D entity) {
    entityManager.persist(entity);
  }

}
