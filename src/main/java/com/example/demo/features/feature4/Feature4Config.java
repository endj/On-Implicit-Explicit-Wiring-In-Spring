package com.example.demo.features.feature4;

import com.example.demo.features.Functionality;
import com.example.demo.framework.FrameWorkTaskRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Feature4Config {

  @Bean
  public Functionality feature4(@Qualifier("bean4task") FrameWorkTaskRunner frameWorkTaskRunner) {
    return new Feature4(frameWorkTaskRunner);
  }
  
  @Bean(name = "bean4task")
  FrameWorkTaskRunner stepRunner(Feature4OverideImplicitTask feature4OverideImplicitTask) {
    return new FrameWorkTaskRunner(feature4OverideImplicitTask);
  }
  
  @Bean
  Feature4OverideImplicitTask over() {
    return new Feature4OverideImplicitTask();
  }
  
  
}
