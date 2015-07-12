package com.fasfsfgs.example.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.fasfsfgs.example.entity.Entity01;
import com.fasfsfgs.example.entity.QEntity01;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Named
public class Entity01DAO extends AbstractDAO<Entity01> {

  @Inject
  private JPAQueryFactory jpaQueryFactory;

  public List<Entity01> getActive() {
    QEntity01 entity01 = QEntity01.entity01;
    return jpaQueryFactory.selectFrom(entity01).where(entity01.active.isTrue()).fetch();
  }

}
