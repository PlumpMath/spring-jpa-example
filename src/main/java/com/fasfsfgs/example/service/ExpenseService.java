package com.fasfsfgs.example.service;

import java.util.Date;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasfsfgs.example.to.ExpenseTO;

@Named
@Path("/expenses")
public class ExpenseService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public ExpenseTO test() {
    ExpenseTO expense = new ExpenseTO();
    expense.setId(1L);
    expense.setDescription("expense description test");
    expense.setDate(new Date());
    return expense;
  }

}
