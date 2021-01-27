# Spring Immutable @ConfigurationProperties PoC

[![Build Status](https://travis-ci.org/rogervinas/spring-immutable-configuration-properties.svg?branch=master)](https://travis-ci.org/rogervinas/spring-immutable-configuration-properties)

🤩 This sample is now much more easier with [@ConstructorBinding](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/ConstructorBinding.html)

## Run

```bash
./gradlew bootRun
```

## Deprecated way

Following this:
* Issue https://github.com/spring-projects/spring-boot/issues/8762
* Latest documentation at  https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-docs/src/main/asciidoc/spring-boot-features.adoc

Latest **org.springframework.boot:2.2.0.BUILD-SNAPSHOT** enables Immutable @ConfigurationProperties if you compile with `-parameters` option.
* Check [AcmeProperties.java](https://github.com/rogervinas/spring-immutable-configuration-properties/blob/master/src/main/java/com/acme/AcmeProperties.java)
* Check [enable -parameters javac option](https://github.com/rogervinas/spring-immutable-configuration-properties/blob/master/build.gradle#L26)

