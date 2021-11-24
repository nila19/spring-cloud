package com.test.springcloud.shipping;

import java.util.UUID;

import com.test.springcloud.shipping.dto.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShippingService {

  public Order ship(Order order) {
    this.processShipment(order);
    return order;
  }

  private void processShipment(Order order) {
    order.setShippingRef(UUID.randomUUID().toString());
    log.info("Processing Shipment; Ref [{}]", order.getShippingRef());
  }
}
