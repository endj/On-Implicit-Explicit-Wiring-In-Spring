package com.example.demo;

import com.example.demo.features.Functionality;
import com.example.demo.framework.ShouldAlwaysBeInstantiated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.common", "com.example.demo.framework", "com.example.demo.features.${feature}"})
@PropertySource(value = "classpath:/${feature}/config.properties")
@PropertySource(value = "classpath:/application.properties")
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(DemoApplication.class);
    app.setBannerMode(Mode.OFF);
    app.setWebApplicationType(WebApplicationType.NONE);
    app.run(args);
  }


  @Bean
  CommandLineRunner commandLineRunner(@Value("${feature}") String feature, Functionality functionality,
      ShouldAlwaysBeInstantiated runner) {
    return args -> {
      System.out.println("Deploying feature: " + feature);
      System.out.println(functionality);
      runner.frameworkCode();
    };
  }
}
