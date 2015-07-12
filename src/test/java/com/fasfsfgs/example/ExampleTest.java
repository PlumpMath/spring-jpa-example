package com.fasfsfgs.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasfsfgs.SpringTestConfig;
import com.fasfsfgs.example.business.GetEntity01;
import com.fasfsfgs.example.business.SaveEntity01;
import com.fasfsfgs.example.entity.Entity01;

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
    List<Entity01> entitiesBefore = getEntity01.get();

    assertTrue("Should have no entities saved.", entitiesBefore.isEmpty());

    Entity01 newEntityA = new Entity01();
    newEntityA.setDescription("A test");
    newEntityA.setActive(true);
    saveEntity01.save(newEntityA);

    Entity01 newEntityB = new Entity01();
    newEntityB.setDescription("B test");
    newEntityB.setActive(false);
    saveEntity01.save(newEntityB);

    List<Entity01> entitiesAfter = getEntity01.get();

    assertEquals("Should have two entities saved.", 2, entitiesAfter.size());

    List<Entity01> activeEntities = getEntity01.getActive();

    assertEquals("Should have only one active entity.", 1, activeEntities.size());
    assertEquals("Active entity fetched should be A test.", "A test", activeEntities.get(0)
        .getDescription());
  }

}
