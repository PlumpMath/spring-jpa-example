package com.fasfsfgs.example.cmd;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.fasfsfgs.example.entity.Expense;

@Named
public class GetExpense {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public Expense get() {
    return em.find(Expense.class, 1L);
  }

}
