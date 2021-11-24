package com.springcloud.checkout.feign;

import com.springcloud.checkout.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("shipping")
public interface ShippingClient {

  @PostMapping("/shipping/process")
  Order process(Order order);
}
