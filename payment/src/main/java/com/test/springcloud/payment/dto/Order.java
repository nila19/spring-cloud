package com.test.springcloud.payment.dto;

import java.util.List;

import lombok.Data;

@Data
public class Order {
  private String orderId;
  private String creditCard;
  private String paymentRef;
  private List<Item> items;
  private double totalCost;
}
