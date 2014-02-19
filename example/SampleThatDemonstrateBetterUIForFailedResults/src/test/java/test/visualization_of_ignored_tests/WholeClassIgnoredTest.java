package test.visualization_of_ignored_tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@Ignore
public class WholeClassIgnoredTest {
	@Test
	public void ok1() {
	}

	@Test
	public void ok2() {
	}

}
