package com.example.demo.common.core.bigclass;


import com.example.demo.common.core.crypto.Crypto;
import com.example.demo.common.core.ftp.Ftp;
import com.example.demo.common.core.xml.Xml;
import lombok.Value;

@Value
public class DoesEverything {

  Ftp sftp;
  Xml xml;
  Crypto crypto;

  public DoesEverything(Ftp ftp, Xml xml, Crypto crypto) {
    this.sftp = ftp;
    this.xml = xml;
    this.crypto = crypto;
  }


}
