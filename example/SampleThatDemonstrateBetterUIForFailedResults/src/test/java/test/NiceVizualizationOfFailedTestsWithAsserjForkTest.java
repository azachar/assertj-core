package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NiceVizualizationOfFailedTestsWithAsserjForkTest {
	class User {
		private String id;

		private String name;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private String email;
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
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
	// b)  you are using the patched version of org.eclipse.jdt.junit4.runtime https://github.com/azachar/org.eclipse.jdt.ui
	@Test
	public void newVisualComparismForAnExoticType() {
		User a = new User();
		a.setId("123456789");
		a.setName("Andrej");
		a.setEmail("andrej@chocolatejar.eu");

		User b = new User();
		b.setId("6789");
		b.setName("Matej");
		b.setEmail("matej@chocolatejar.eu");

		assertThat(a).isEqualToComparingFieldByField(b);
	}
	
	@Test
	public void clasicCompare() {
		assertThat("Andrej ZACHAR").isEqualTo("Matej ZACHAR");
	}

}
