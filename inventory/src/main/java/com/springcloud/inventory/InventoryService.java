package com.springcloud.inventory;

import java.text.MessageFormat;
import java.util.UUID;
import javax.annotation.PostConstruct;

import com.springcloud.inventory.dto.Item;
import com.springcloud.inventory.dto.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@RefreshScope
public class InventoryService {

  @Value("${app.qty.limit}")
  private int qtyLimit;

  @PostConstruct
  public void init() {
    log.info("Qty limit = [{}]", this.qtyLimit);
  }

  public Order process(Order order) {
    this.checkInventory(order);
    this.adjustInventory(order);
    return order;
  }

  private void checkInventory(Order order) {
    boolean largeOrder = order.getItems().stream()
        .map(Item::getQty)
        .anyMatch(e -> e > this.qtyLimit);

    if (largeOrder) {
      String msg = MessageFormat.format("Item qty exceeds threshold [{0}]", this.qtyLimit);
      throw new InventoryException(msg);
    }
  }

  private void adjustInventory(Order order) {
    log.info("Adjusting inventory; Order [{}]", order.getOrderId());
    order.setInventoryRef(UUID.randomUUID().toString());
  }
}
