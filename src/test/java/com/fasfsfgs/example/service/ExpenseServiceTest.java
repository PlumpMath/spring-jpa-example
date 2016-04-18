package com.fasfsfgs.example.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasfsfgs.SpringTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestConfig.class)
public class ExpenseServiceTest {

  @Inject
  private ExpenseService expenseService;

  @Test
  public void test() {
    assertNotNull(expenseService);
  }

}
