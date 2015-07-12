package com.fasfsfgs.example.business;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasfsfgs.example.dao.Entity01DAO;
import com.fasfsfgs.example.entity.Entity01;

@RunWith(MockitoJUnitRunner.class)
public class SaveEntity01Test {

  @InjectMocks
  private SaveEntity01 saveEntity01;

  @Mock
  private Entity01DAO entity01DAO;

  @Test
  public void test() {
    Entity01 entity01 = new Entity01();

    saveEntity01.save(entity01);

    verify(entity01DAO).save(entity01);
  }

}
