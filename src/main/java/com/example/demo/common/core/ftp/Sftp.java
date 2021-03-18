package com.example.demo.common.core.ftp;

import lombok.Value;

@Value
public class Sftp implements Ftp {

  Client client;

  public Sftp(Client client) {
    this.client = client;
  }
}
