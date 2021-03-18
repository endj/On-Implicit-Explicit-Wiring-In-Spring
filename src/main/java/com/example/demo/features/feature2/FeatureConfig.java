package com.example.demo.features.feature2;

import com.example.demo.common.core.crypto.Encrypter;
import com.example.demo.common.core.ftp.Sftp;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeatureConfig {

  @Bean
  @ConditionalOnProperty({"ftp.enabled", "crypto.enabled"})
  public Feature2 feature2(Sftp ftp, Encrypter encrypter) {
    return new Feature2(ftp, encrypter);
  }

  @Bean("crypto.enabled")
  public Feature2 feature2CustomFtp(Feature2Ftp ftp, Encrypter encrypter) {
    return new Feature2(ftp, encrypter);
  }

  @Bean
  public Feature2Ftp customFileThigny() {
    return new Feature2Ftp() {
    };
  }


}
