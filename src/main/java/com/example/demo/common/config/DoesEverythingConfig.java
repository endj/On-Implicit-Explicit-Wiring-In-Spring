package com.example.demo.common.config;

import com.example.demo.common.core.bigclass.DoesEverything;
import com.example.demo.common.core.crypto.Crypto;
import com.example.demo.common.core.ftp.Sftp;
import com.example.demo.common.core.xml.Xml;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty({"ftp.enabled", "xml.enabled", "crypto.enabled"})
public class DoesEverythingConfig {

  @Bean
  DoesEverything defaultImplementation(Sftp sftp, Xml xml, Crypto crypto) {
    return new DoesEverything(sftp, xml, crypto);
  }

}
