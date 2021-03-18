package com.example.demo.features.feature1;

import com.example.demo.features.Functionality;
import com.example.demo.common.core.bigclass.DoesEverything;
import com.example.demo.common.core.crypto.Encrypter;
import com.example.demo.common.core.xml.Xml;
import lombok.Value;

@Value
public class Feature1 implements Functionality {

  Xml xml;
  Encrypter encrypter;
  DoesEverything doesEverything;

}
