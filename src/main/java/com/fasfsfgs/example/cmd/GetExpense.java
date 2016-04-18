package com.fasfsfgs.example.cmd;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fasfsfgs.example.entity.Expense;

@Named
public class GetExpense {

  @PersistenceContext
  private EntityManager em;

  public Expense get() {
    return em.find(Expense.class, 1L);
  }

  public Expense save() {
    Expense expense = new Expense();
    expense.setDescription("insert test");
    expense.setDate(new Date());
    expense.setExpenseCost(BigDecimal.ONE);
    expense.setPaymentSource(1);
    expense.setType(1);

    em.persist(expense);

    return expense;
  }

}
