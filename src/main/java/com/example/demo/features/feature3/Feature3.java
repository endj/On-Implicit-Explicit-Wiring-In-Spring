package com.example.demo.features.feature3;

import com.example.demo.features.Functionality;
import com.example.demo.common.core.bigclass.DoesEverything;
import com.example.demo.common.core.crypto.Crypto;
import com.example.demo.common.core.ftp.Client;
import com.example.demo.common.core.ftp.Ftp;
import com.example.demo.common.core.xml.Parser;
import com.example.demo.common.core.xml.Xml;
import lombok.Value;

@Value
public class Feature3 implements Functionality {

  DoesEverything doesEverything;
  Xml xml;
  Ftp ftp;
  Crypto crypto;
  Parser parser;
  Client client;

}
