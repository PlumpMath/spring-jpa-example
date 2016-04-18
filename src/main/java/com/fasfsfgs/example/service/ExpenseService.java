package com.fasfsfgs.example.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
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
  @Transactional
  public ExpenseTO test() {
    Expense exampleExpense = getExpense.get();
    System.out.println(exampleExpense);

    Expense expense = getExpense.save();

    ExpenseTO expenseTO = new ExpenseTO();
    expenseTO.setId(expense.getId());
    expenseTO.setDescription(expense.getDescription());
    expenseTO.setDate(expense.getDate());
    expenseTO.setExpenseCost(expense.getExpenseCost());
    expenseTO.setPaymentSource(expense.getPaymentSource());
    expenseTO.setType(expense.getType());

    return expenseTO;
  }

}
