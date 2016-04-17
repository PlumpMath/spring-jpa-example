package com.fasfsfgs.example.cmd;

import javax.inject.Named;

@Named
public class GetExpense {

  public void get() {
    System.out.println("injection worked!");
  }

}
