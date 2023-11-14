package com.acme;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableConfigurationProperties({
  AcmeJavaClassProperties.class,
  AcmeJavaRecordProperties.class,
  AcmeKotlinClassProperties.class,
  AcmeKotlinDataClassProperties.class
})
public class AcmeApplication {

  public static void main(String[] args) {
    run(AcmeApplication.class, args);
  }
}
