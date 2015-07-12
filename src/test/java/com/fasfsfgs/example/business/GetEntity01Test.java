package com.fasfsfgs.example.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasfsfgs.example.dao.Entity01DAO;
import com.fasfsfgs.example.entity.Entity01;

@RunWith(MockitoJUnitRunner.class)
public class GetEntity01Test {

  @InjectMocks
  private GetEntity01 getEntity01;

  @Mock
  private Entity01DAO entity01DAO;

  @Test
  public void testGet() {
    List<Entity01> entities = new ArrayList<Entity01>();
    entities.add(new Entity01());
    when(entity01DAO.getAll()).thenReturn(entities);

    List<Entity01> result = getEntity01.get();

    assertEquals(entities, result);
  }

  @Test
  public void testGetActive() {
    List<Entity01> entities = new ArrayList<Entity01>();
    entities.add(new Entity01());
    when(entity01DAO.getActive()).thenReturn(entities);

    List<Entity01> result = getEntity01.getActive();

    assertEquals(entities, result);
  }

}
