package com.springcloud.inventory.dto;

import lombok.Data;

@Data
public class Item {
  private int qty;
  private double unitPrice;
  private double cost;
}
