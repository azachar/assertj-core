package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AssertjSampleTest {

	class User {
		private String id;

		private String name;
		
		public String getIgnored() {
			return name;
		}

		public void setIgnored(String ignored) {
			this.name = ignored;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}

	// ENSURE THAT
	// a)  assert-core 1.6.0.SNAPSHOT is compiled from https://github.com/azachar/assertj-core
	// b)  you are using the patched version of org.eclipse.jdt.junit4.runtime https://github.com/azachar/org.eclipse.jdt.junit4.runtime/tree/assertj_in_R4_3_1/org.eclipse.jdt.junit4.runtime
	@Test
	public void newVisualComparismForAnExoticType() {
		User a = new User();
		a.setId("a");

		User b = new User();
		b.setId("b");

		assertThat(a).isEqualToIgnoringGivenFields(b);
	}
	@Test
	public void clasicCompare() {
		assertThat("Andrej ZACHAR").isEqualTo("Matej ZACHAR");
	}

}
