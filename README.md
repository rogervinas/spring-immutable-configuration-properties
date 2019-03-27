# Spring Immutable @ConfigurationProperties PoC

Following this:
* Issue https://github.com/spring-projects/spring-boot/issues/8762
* Latest documentation at  https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-docs/src/main/asciidoc/spring-boot-features.adoc

Latest **org.springframework.boot:2.2.0.BUILD-SNAPSHOT** enables Immutable @ConfigurationProperties if you compile with `-parameters` option.
* Check [AcmeProperties.java](https://github.com/rogervinas/spring-immutable-configuration-properties/blob/master/src/main/java/com/acme/AcmeProperties.java)
* Check [enable -parameters javac option](https://github.com/rogervinas/spring-immutable-configuration-properties/blob/master/build.gradle#L26)

## Run
```bash
./gradlew bootRun
```