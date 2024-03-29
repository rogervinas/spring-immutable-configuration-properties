package com.acme;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static java.util.Collections.unmodifiableList;

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

  public boolean isEnabled() {
    return enabled;
  }

  public String getText() {
    return text;
  }

  public List<String> getList() {
    return list;
  }

  public float getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return "AcmeProperties{" +
      "enabled=" + enabled +
      ", text='" + text + '\'' +
      ", list=" + list +
      ", number=" + number +
      '}';
  }
}
