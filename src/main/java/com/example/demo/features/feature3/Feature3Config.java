package com.example.demo.features.feature3;

import com.example.demo.common.core.bigclass.DoesEverything;
import com.example.demo.common.core.crypto.Crypto;
import com.example.demo.common.core.ftp.Client;
import com.example.demo.common.core.ftp.Sftp;
import com.example.demo.common.core.xml.Parser;
import com.example.demo.common.core.xml.Xml;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Feature3Config {

  @Bean
  public Feature3 feature3(DoesEverything doesEverything, Xml xml, Crypto crypto, Sftp ftp, Parser parser, Client client) {
    return new Feature3(doesEverything, xml, ftp, crypto, parser, client);
  }

}
