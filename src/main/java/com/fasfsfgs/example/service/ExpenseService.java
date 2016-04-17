package com.fasfsfgs.example.service;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasfsfgs.example.cmd.GetExpense;
import com.fasfsfgs.example.entity.Expense;
import com.fasfsfgs.example.to.ExpenseTO;

@Named
@Path("/expenses")
public class ExpenseService {

  @Inject
  private GetExpense getExpense;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public ExpenseTO test() {
    Expense expenseEntity = getExpense.get();
    System.out.println(expenseEntity);

    ExpenseTO expense = new ExpenseTO();
    expense.setId(1L);
    expense.setDescription("expense description test");
    expense.setDate(new Date());
    return expense;
  }

}
