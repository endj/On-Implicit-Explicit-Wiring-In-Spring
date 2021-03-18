package com.example.demo.common.core.ftp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sftp")
@Data
public class SftpProperties {

  String a;
  String b;
}
