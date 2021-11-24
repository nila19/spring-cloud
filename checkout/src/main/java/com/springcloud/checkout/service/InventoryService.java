package com.springcloud.checkout.service;

import com.springcloud.checkout.Order;
import com.springcloud.checkout.config.AppProps;
import com.springcloud.checkout.feign.InventoryClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryService {
  private static final String REST_URL = "http://localhost:8083/inventory/process";

  private final AppProps appProps;
  private final RestHelper restHelper;
  private final InventoryClient inventoryClient;

  public Order callInventory(Order order) {
    boolean feignEnabled = this.appProps.getFeign().isEnabled();
    return feignEnabled ? this.inventoryClient.process(order) : this.restHelper.makeRestCall(REST_URL, order);
  }
}
