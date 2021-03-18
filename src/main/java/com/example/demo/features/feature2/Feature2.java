package com.example.demo.features.feature2;

import com.example.demo.features.Functionality;
import com.example.demo.common.core.crypto.Encrypter;
import com.example.demo.common.core.ftp.Ftp;
import lombok.Value;

@Value
public class Feature2 implements Functionality {

  Ftp ftp;
  Encrypter encrypter;
  
}
