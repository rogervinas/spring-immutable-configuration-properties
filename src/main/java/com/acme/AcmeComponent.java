package com.acme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@EnableConfigurationProperties(AcmeProperties.class)
public class AcmeComponent {

  private final static Logger LOGGER = LoggerFactory.getLogger(AcmeComponent.class);

  private final AcmeProperties props;

  public AcmeComponent(AcmeProperties properties) {
    this.props = properties;
  }

  @Scheduled(fixedDelayString = "${app.schedule}")
  public void printProperties() {
    LOGGER.info(props.toString());
  }
}
