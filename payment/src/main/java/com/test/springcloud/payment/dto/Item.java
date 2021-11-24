package com.test.springcloud.payment.dto;

import lombok.Data;

@Data
public class Item {
  private int qty;
  private double unitPrice;
  private double cost;
}
