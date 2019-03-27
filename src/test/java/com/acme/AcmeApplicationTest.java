package com.acme;

import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcmeApplicationTest {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

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
	public void should_print_properties() {
		await()
				.atMost(2 * schedule, TimeUnit.MILLISECONDS)
				.until(() -> outputCapture.toString().contains("AcmeProperties{enabled=true, text='hello world', list=[one, two, three], number=3.14}"));
	}
}
