package com.example.demo.common.config;

import com.example.demo.common.core.ftp.Client;
import com.example.demo.common.core.ftp.Sftp;
import com.example.demo.common.core.ftp.SftpClient;
import com.example.demo.common.core.ftp.SftpProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "ftp.enabled")
public class FtpConfig {

  @Bean
  Sftp sftp(Client client) {
    return new Sftp(client);
  }

  @Bean
  Client client(SftpProperties sftpProperties) {
    return new SftpClient(sftpProperties);
  }
}
