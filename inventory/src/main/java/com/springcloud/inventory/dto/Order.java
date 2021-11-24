package com.springcloud.inventory.dto;

import java.util.List;

import lombok.Data;

@Data
public class Order {
  private String orderId;
  private String inventoryRef;

  private List<Item> items;
}
