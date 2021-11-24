package com.springcloud.checkout.service;

import com.springcloud.checkout.Order;
import com.springcloud.checkout.config.AppProps;
import com.springcloud.checkout.feign.ShippingClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShippingService {
  private static final String REST_URL = "http://localhost:8085/shipping/process";

  private final AppProps appProps;
  private final RestHelper restHelper;
  private final ShippingClient shippingClient;

  public Order callShipping(Order order) {
    boolean feignEnabled = this.appProps.getFeign().isEnabled();
    return feignEnabled ? this.shippingClient.process(order) : this.restHelper.makeRestCall(REST_URL, order);
  }
}
