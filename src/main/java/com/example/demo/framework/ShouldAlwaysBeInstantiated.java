package com.example.demo.framework;

import org.springframework.stereotype.Component;

@Component
public class ShouldAlwaysBeInstantiated {

  public void frameworkCode() {
    if(1==1){}
  }
}
