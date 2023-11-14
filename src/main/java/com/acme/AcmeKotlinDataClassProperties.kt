package com.acme

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("acme")
data class AcmeKotlinDataClassProperties (
  val enabled: Boolean,
  val text: String,
  val list: List<String>,
  val number: Float
)
