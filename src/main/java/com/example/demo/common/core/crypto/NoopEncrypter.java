package com.example.demo.common.core.crypto;

import lombok.Value;

@Value
public class NoopEncrypter implements Encrypter {

  CryptoProperties config;

}
