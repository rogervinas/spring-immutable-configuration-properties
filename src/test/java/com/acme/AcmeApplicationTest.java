package com.acme;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AcmeApplicationTest {

  @Autowired
  private ApplicationContext context;

  @Test
  public void should_load_java_class_properties() {
    var bean = context.getBean(AcmeJavaClassProperties.class);
    assertThat(bean).isNotNull();
    assertValuesAreAsExpected(bean.isEnabled(), bean.getText(), bean.getNumber(), bean.getList());
  }

  @Test
  public void should_load_java_record_properties() {
    var bean = context.getBean(AcmeJavaRecordProperties.class);
    assertThat(bean).isNotNull();
    assertValuesAreAsExpected(bean.enabled(), bean.text(), bean.number(), bean.list());
  }

  @Test
  public void should_load_kotlin_class_properties() {
    var bean = context.getBean(AcmeKotlinClassProperties.class);
    assertThat(bean).isNotNull();
    assertValuesAreAsExpected(bean.getEnabled(), bean.getText(), bean.getNumber(), bean.getList());
  }

  @Test
  public void should_load_kotlin_data_class_properties() {
    var bean = context.getBean(AcmeKotlinDataClassProperties.class);
    assertThat(bean).isNotNull();
    assertValuesAreAsExpected(bean.getEnabled(), bean.getText(), bean.getNumber(), bean.getList());
  }

  private void assertValuesAreAsExpected(boolean enabled, String text, float number, List<String> list) {
    assertThat(enabled).isEqualTo(true);
    assertThat(text).isEqualTo("hello world");
    assertThat(number).isEqualTo(3.14f);
    assertThat(list).containsExactlyInAnyOrder("one", "two", "three");
  }

}
