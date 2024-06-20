package com.acme

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("acme")
class AcmeKotlinClassProperties(
  val enabled: Boolean,
  val text: String,
  val list: List<String>,
  val number: Float,
)
