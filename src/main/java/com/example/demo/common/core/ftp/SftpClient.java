package com.example.demo.common.core.ftp;

import lombok.Value;

@Value
public class SftpClient implements Client {

  SftpProperties sftpConfig;

}
