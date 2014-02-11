/*
 * Created on Mar 19, 2012
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the
 * License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 * 
 * Copyright @2012 the original author or authors.
 */
package org.assertj.core.error;

import java.util.List;

/**
 * Creates an <code>{@link AssertionError}</code> indicating that an assertion that verifies that two objects are lenient equal by ignoring fields failed.
 * 
 * @author Nicolas François
 * @author Joel Costigliola
 * @author Andrej Zachar
 */
public class ShouldBeEqualToIgnoringFields extends BasicErrorMessageFactory {

	private static final String EXPECTED_MULTIPLE = "\nExpecting values:\n  <%s>\nin fields:\n  <%s>\nbut were:\n  <%s>\nin <%s>.\n";

	private static final String EXPECTED_SINGLE = "\nExpecting value <%s> in field <%s> but was <%s> in <%s>.\n";

	private static final String COMPARISON = "Comparison was performed on all fields";

	private static final String EXCLUDING = " but <%s>";

	/**
	 * Creates a new </code>{@link ShouldBeEqualToIgnoringFields}</code>.
	 * 
	 * @param actual
	 *            the actual value in the failed assertion.
	 * @param rejectedFields
	 *            fields name not matching
	 * @param rejectedValues
	 *            rejected fields values
	 * @param expectedValues
	 *            expected fields values
	 * @param ignoredFields
	 *            fields which are not base the lenient equality
	 * @return the created {@code ErrorMessageFactory}.
	 */
	public static ErrorMessageFactory shouldBeEqualToIgnoringGivenFields(Object actual, List<String> rejectedFields, List<Object> rejectedValues,
			List<Object> expectedValues, List<String> ignoredFields) {

		String optionalMessage = generateOptionalMessage(actual, rejectedFields, rejectedValues, expectedValues);

		if (rejectedFields.size() == 1) {
			if (ignoredFields.isEmpty()) {
				return new ShouldBeEqualToIgnoringFields(optionalMessage, actual, rejectedFields.get(0), rejectedValues.get(0), expectedValues.get(0));
			} else {
				return new ShouldBeEqualToIgnoringFields(optionalMessage, actual, rejectedFields.get(0), rejectedValues.get(0), expectedValues.get(0),
						ignoredFields);
			}
		} else {
			if (ignoredFields.isEmpty()) {
				return new ShouldBeEqualToIgnoringFields(optionalMessage, actual, rejectedFields, rejectedValues, expectedValues);
			} else {
				return new ShouldBeEqualToIgnoringFields(optionalMessage, actual, rejectedFields, rejectedValues, expectedValues, ignoredFields);
			}
		}
	}

	private ShouldBeEqualToIgnoringFields(String comparismOptionalMessage, Object actual, List<String> rejectedFields, List<Object> rejectedValues,
			List<Object> expectedValues, List<String> ignoredFields) {
		super(EXPECTED_MULTIPLE + COMPARISON + EXCLUDING, expectedValues, rejectedFields, rejectedValues, actual, ignoredFields);
		this.comparismOptionalMessage = comparismOptionalMessage;
	}

	private ShouldBeEqualToIgnoringFields(String comparismOptionalMessage, Object actual, String rejectedField, Object rejectedValue, Object expectedValue,
			List<String> ignoredFields) {
		super(EXPECTED_SINGLE + COMPARISON + EXCLUDING, expectedValue, rejectedField, rejectedValue, actual, ignoredFields);
		this.comparismOptionalMessage = comparismOptionalMessage;
	}

	private ShouldBeEqualToIgnoringFields(String comparismOptionalMessage, Object actual, List<String> rejectedFields, List<Object> rejectedValues,
			List<Object> expectedValue) {
		super(EXPECTED_MULTIPLE + COMPARISON, expectedValue, rejectedFields, rejectedValues, actual);
		this.comparismOptionalMessage = comparismOptionalMessage;
	}

	private ShouldBeEqualToIgnoringFields(String comparismOptionalMessage, Object actual, String rejectedField, Object rejectedValue, Object expectedValue) {
		super(EXPECTED_SINGLE + COMPARISON, expectedValue, rejectedField, rejectedValue, actual);
		this.comparismOptionalMessage = comparismOptionalMessage;
	}

	private static final String EXPECTED_DELIMITER = "\n__EX__";

	private static final String ACTUAL_DELIMITER = "__AC__";

	private static final String END_DELIMITER = "__EN__";

	private static String generateOptionalMessage(Object actual, List<String> rejectedFields, List<Object> rejectedValues, List<Object> expectedValues) {

		String left = generateMessage(actual, rejectedFields, expectedValues);
		String right = generateMessage(actual, rejectedFields, rejectedValues);

		return EXPECTED_DELIMITER + left + ACTUAL_DELIMITER + right+END_DELIMITER;
	}

	private static String generateMessage(Object object, List<String> fields, List<Object> values) {
		StringBuilder msg = new StringBuilder();

		msg.append(object.getClass().getName());
		msg.append("\n");

		int i = 0;
		for (String field : fields) {
			msg.append("↳ ");
			msg.append(field);
			msg.append(" = [");
			msg.append(values.get(i));
			msg.append("]");

			i++;
		}
		return msg.toString();
	}
}
