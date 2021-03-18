package com.example.demo.common.config;

import com.example.demo.common.core.crypto.Crypto;
import com.example.demo.common.core.crypto.CryptoProperties;
import com.example.demo.common.core.crypto.Encrypter;
import com.example.demo.common.core.crypto.NoopEncrypter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "crypto.enabled")
public class CryptoConfig {

  @Bean
  public Crypto crypto(Encrypter encrypter) {
    return new Crypto(encrypter);
  }

  @Bean
  public Encrypter encrypter(CryptoProperties config) {
    return new NoopEncrypter(config);
  }
}
