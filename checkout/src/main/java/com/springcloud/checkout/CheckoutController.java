package com.springcloud.checkout;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
@RequiredArgsConstructor
public class CheckoutController {
  private static final String JSON = APPLICATION_JSON_VALUE;

  private final CheckoutService checkoutService;

  @PostMapping(value = "/process", consumes = JSON, produces = JSON)
  public ResponseEntity<Order> process(@RequestBody Cart cart) {
    return ResponseEntity.ok(this.checkoutService.process(cart));
  }
}
