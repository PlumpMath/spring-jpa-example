package com.fasfsfgs.example.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fasfsfgs.example.entity.Entity01;
import com.fasfsfgs.example.entity.QEntity01;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Named
public class Entity01DAO {

  @Inject
  private JPAQueryFactory jpaQueryFactory;

  @PersistenceContext
  private EntityManager entityManager;

  public List<Entity01> getAll() {
    QEntity01 entity01 = QEntity01.entity01;

    JPAQuery<Entity01> query = jpaQueryFactory.selectFrom(entity01);

    return query.fetch();
  }

  public void save(Entity01 entity01) {
    entityManager.persist(entity01);
  }

}
