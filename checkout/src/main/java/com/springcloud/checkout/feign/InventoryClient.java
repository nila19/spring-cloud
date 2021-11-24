package com.springcloud.checkout.feign;

import com.springcloud.checkout.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("inventory")
public interface InventoryClient {

  @PostMapping("/inventory/process")
  Order process(Order order);
}
