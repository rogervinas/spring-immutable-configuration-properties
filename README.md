[![CI](https://github.com/rogervinas/spring-immutable-configuration-properties/actions/workflows/gradle.yml/badge.svg?branch=master)](https://github.com/rogervinas/spring-immutable-configuration-properties/actions/workflows/gradle.yml)
![Java](https://img.shields.io/badge/Java-21-blue?labelColor=black)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-blue?labelColor=black)
![SpringBoot](https://img.shields.io/badge/SpringBoot-3.2.0-blue?labelColor=black)

# Spring Immutable @ConfigurationProperties

There are at least 4 ways of having **immutable** properties loaded from configuration:

1) [A plain Java class](src/main/java/com/acme/AcmeJavaClassProperties.java)
```java
@ConfigurationProperties("acme")
public class AcmeJavaClassProperties {

  private final boolean enabled;
  private final String text;
  private final List<String> list;
  private final float number;

  public AcmeJavaClassProperties(
    boolean enabled,
    String text,
    List<String> list,
    float number
  ) {
    this.enabled = enabled;
    this.text = text;
    this.list = unmodifiableList(list);
    this.number = number;
    }
}
```

2) [A Java record](src/main/java/com/acme/AcmeJavaRecordProperties.java)
```java
@ConfigurationProperties("acme")
public record AcmeJavaRecordProperties(
  boolean enabled,
  String text,
  List<String> list,
  float number
) {
}
```

3) [A plain Kotlin class](src/main/java/com/acme/AcmeKotlinClassProperties.kt)
```kotlin
@ConfigurationProperties("acme")
class AcmeKotlinClassProperties(
  val enabled: Boolean,
  val text: String,
  val list: List<String>,
  val number: Float
)
```

4) [A Kotlin data class](src/main/java/com/acme/AcmeKotlinDataClassProperties.kt)
```kotlin
@ConfigurationProperties("acme")
data class AcmeKotlinDataClassProperties (
  val enabled: Boolean,
  val text: String,
  val list: List<String>,
  val number: Float
)
```

Note that since Spring Boot 3.x [@ConstructorBinding](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/bind/ConstructorBinding.html) annotation is only required to indicate which constructor to use in case there is more than one.

You can also browse older versions:
* [Spring Boot 2.x](https://github.com/rogervinas/spring-immutable-configuration-properties/tree/spring-boot-2.x)

## Test

Review [AcmeApplicationTest](src/test/java/com/acme/AcmeApplicationTest.java) and ...

```bash
./gradlew test
```
