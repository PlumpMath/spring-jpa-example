package com.fasfsfgs.example.business;

import javax.inject.Inject;
import javax.inject.Named;

import com.fasfsfgs.example.dao.Entity01DAO;
import com.fasfsfgs.example.entity.Entity01;

@Named
public class SaveEntity01 {

  @Inject
  private Entity01DAO entity01DAO;

  public void save(Entity01 entity01) {
    entity01DAO.save(entity01);
  }

}
