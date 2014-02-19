package test.visualization_of_ignored_tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AllIgnoredMethodsTest {
	
	@Test
	@Ignore
	public void ignored1() {
	}

	@Test
	@Ignore
	public void ignored2() {
	}

}
