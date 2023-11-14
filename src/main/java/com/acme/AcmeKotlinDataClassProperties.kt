package com.acme

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("acme")
data class AcmeKotlinDataClassProperties (
  val enabled: Boolean,
  val text: String,
  val list: List<String>,
  val number: Float
)
