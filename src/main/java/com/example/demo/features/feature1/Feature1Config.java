package com.example.demo.features.feature1;

import com.example.demo.common.core.bigclass.DoesEverything;
import com.example.demo.common.core.crypto.Crypto;
import com.example.demo.common.core.crypto.Encrypter;
import com.example.demo.common.core.ftp.Ftp;
import com.example.demo.common.core.xml.Xml;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Feature1Config {

  @Bean
  public Feature1 feature1(Xml xml, Encrypter encrypter, @Qualifier("feature1SpecificStuff") DoesEverything doesEverything) {
    return new Feature1(xml, encrypter, doesEverything);
  }

  @Bean(name = "feature1SpecificStuff")
  public DoesEverything withCustomerParser(@Qualifier("feature1Ftp") Ftp ftp, @Qualifier("specialXmlParsingImplementation") Xml xml,
      Crypto crypto) {
    return new DoesEverything(ftp, xml, crypto);
  }
  
  @Bean(name = "feature1Ftp")
  public Ftp customFtp() {
    return new Ftp() {
    };
  }

  @Bean(name = "specialXmlParsingImplementation")
  public Xml feature1SpecificXml(Feature1Parser parser) {
    return new Xml(parser);
  }

  @Bean
  public Feature1Parser feature1SpecificParser() {
    return new Feature1Parser();
  }

}
