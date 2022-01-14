package com.acme;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
public class AcmeApplicationTest {

	@Value("${app.schedule}")
	private long schedule;

	@Autowired
	private AcmeProperties properties;

	@Test
	public void should_load_properties() {
		assertThat(properties.isEnabled()).isEqualTo(true);
		assertThat(properties.getText()).isEqualTo("hello world");
		assertThat(properties.getNumber()).isEqualTo(3.14f);
		assertThat(properties.getList()).containsExactlyInAnyOrder("one", "two", "three");
	}

	@Test
	public void should_print_properties(CapturedOutput capturedOutput) {
		await()
				.atMost(2 * schedule, TimeUnit.MILLISECONDS)
				.until(() -> capturedOutput.toString().contains("AcmeProperties{enabled=true, text='hello world', list=[one, two, three], number=3.14}"));
	}
}
