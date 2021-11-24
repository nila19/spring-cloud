package com.springcloud.checkout;

import java.util.UUID;

import com.springcloud.checkout.service.InventoryService;
import com.springcloud.checkout.service.PaymentService;
import com.springcloud.checkout.service.ShippingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckoutService {
  private final InventoryService inventoryService;
  private final PaymentService paymentService;
  private final ShippingService shippingService;

  public Order process(Cart cart) {
    Order order = new Order(cart);
    order.setOrderId(UUID.randomUUID().toString());

    Order inventoryOrder = this.inventoryService.callInventory(order);
    if (inventoryOrder != null) {
      order.setInventoryRef(inventoryOrder.getInventoryRef());
    }

    Order paymentOrder = this.paymentService.callPayment(order);
    if (paymentOrder != null) {
      order.setPaymentRef(paymentOrder.getPaymentRef());
      order.setTotalCost(paymentOrder.getTotalCost());
      order.setItems(paymentOrder.getItems());
    }

    Order shippingOrder = this.shippingService.callShipping(order);
    if (shippingOrder != null) {
      order.setShippingRef(shippingOrder.getShippingRef());
    }

    return order;
  }
}
