package test.visualization_of_ignored_tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SomeMethodAreIgnoredTest {
	@Test
	public void ok() {
	}
	
	@Test
	public void ok2() {
	}
	
	@Test
	@Ignore
	public void ignored() {
	}

}
