package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SomeTestOkSomeFailedTest {

	@Test
	public void ok() {
		assertThat("Andrej").isEqualTo("Andrej");
	}

	@Test
	public void failed() {
		assertThat("Matej").isEqualTo("Andrej");
	}

	@Test
	public void error() {
		throw new RuntimeException("Your exotic exception!!");
	}

}
