package com.fasfsfgs.example;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasfsfgs.example.business.GetEntity01;
import com.fasfsfgs.example.business.SaveEntity01;
import com.fasfsfgs.example.entity.Entity01;
import com.fasfsfgs.infra.config.SpringTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestConfig.class)
public class ExampleTest {

  @Inject
  private GetEntity01 getEntity01;

  @Inject
  private SaveEntity01 saveEntity01;

  @Test
  @Transactional
  public void test() {
    List<Entity01> entities = getEntity01.get();

    Assert.assertTrue("Should have no entities saved.", entities.isEmpty());

    Entity01 newEntity = new Entity01();
    newEntity.setDescription("test");
    saveEntity01.save(newEntity);

    entities = getEntity01.get();

    Assert.assertEquals("Should have one entity saved.", 1, entities.size());

    Assert.assertEquals("Entity fetched should be the one saved.", "test", entities.get(0)
        .getDescription());
  }

}
