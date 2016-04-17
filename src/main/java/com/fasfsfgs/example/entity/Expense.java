package com.fasfsfgs.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class Expense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true, insertable = false, updatable = false)
  private Long id;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "date", nullable = false)
  private Date date;

  @Column(name = "type", nullable = false)
  private Integer type;

  @Column(name = "payment_source", nullable = false)
  private Integer paymentSource;

  @Column(name = "expense_cost", nullable = false)
  private Double expenseCost;

  public Expense() {}

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

  public Double getExpenseCost() {
    return expenseCost;
  }

  public void setExpenseCost(Double expenseCost) {
    this.expenseCost = expenseCost;
  }

}
