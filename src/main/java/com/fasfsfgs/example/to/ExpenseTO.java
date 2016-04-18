package com.fasfsfgs.example.to;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseTO {

  private Long id;

  private String description;

  private Date date;

  private Integer type;

  private Integer paymentSource;

  private BigDecimal expenseCost;

  public ExpenseTO() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getPaymentSource() {
    return paymentSource;
  }

  public void setPaymentSource(Integer paymentSource) {
    this.paymentSource = paymentSource;
  }

  public BigDecimal getExpenseCost() {
    return expenseCost;
  }

  public void setExpenseCost(BigDecimal expenseCost) {
    this.expenseCost = expenseCost;
  }

}
