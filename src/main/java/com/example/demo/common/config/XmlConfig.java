package com.example.demo.common.config;

import com.example.demo.common.core.xml.Parser;
import com.example.demo.common.core.xml.TextParser;
import com.example.demo.common.core.xml.Xml;
import com.example.demo.common.core.xml.XmlProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "xml.enabled")
public class XmlConfig {

  @Bean
  public Xml xml(Parser parser) {
    return new Xml(parser);
  }

  @Bean
  public Parser parser(XmlProperties xmlProperties) {
    return new TextParser(xmlProperties);
  }
}
