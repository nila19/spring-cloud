package com.springcloud.inventory;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.springcloud.inventory.dto.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
  private static final String JSON = APPLICATION_JSON_VALUE;

  private final InventoryService inventoryService;

  @PostMapping(value = "/process", consumes = JSON, produces = JSON)
  public ResponseEntity<Order> process(@RequestBody Order order) {
    return ResponseEntity.ok(this.inventoryService.process(order));
  }
}
