package com.example.demo.common.core.xml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "xml")
@Data
public class XmlProperties {

  String a;
  String b;
}
