package com.acme;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("acme")
public record AcmeJavaRecordProperties(
  boolean enabled,
  String text,
  List<String> list,
  float number
) {
}
