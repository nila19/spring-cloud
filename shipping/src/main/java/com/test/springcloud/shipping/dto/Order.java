package com.test.springcloud.shipping.dto;

import lombok.Data;

@Data
public class Order {
  private String orderId;
  private String legalName;
  private Address address;
  private String shippingRef;
}
