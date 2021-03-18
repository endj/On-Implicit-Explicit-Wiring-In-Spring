package com.example.demo.common.core.crypto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "crypto")
@Data
public class CryptoProperties {

  String a;
  String b;
}
