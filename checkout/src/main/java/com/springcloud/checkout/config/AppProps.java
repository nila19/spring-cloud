package com.springcloud.checkout.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProps {
  private Feign feign = new Feign();

  @Data
  public static class Feign {
    private boolean enabled;
  }
}
