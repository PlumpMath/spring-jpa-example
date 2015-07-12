package com.fasfsfgs.example.business;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.fasfsfgs.example.dao.Entity01DAO;
import com.fasfsfgs.example.entity.Entity01;

@Named
public class GetEntity01 {

  @Inject
  private Entity01DAO entity01DAO;

  public List<Entity01> get() {
    return entity01DAO.getAll();
  }

  public List<Entity01> getActive() {
    return entity01DAO.getActive();
  }

}
