/*
 * Created on Jun 3, 2012
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2010-2012 the original author or authors.
 */
package org.assertj.core.error;

import java.util.Set;

import org.assertj.core.util.Strings;

/**
 * Creates an error message indicating that an assertion that verifies a map contains a key..
 * 
 * @author Nicolas François
 */
public class ShouldContainKey extends BasicErrorMessageFactory {

  /**
   * Creates a new </code>{@link ShouldContainKey}</code>.
   * 
   * @param actual the actual value in the failed assertion.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static <K> ErrorMessageFactory shouldContainKey(Object actual, Set<K> key) {
    return new ShouldContainKey(actual, key);
  }

  private <K> ShouldContainKey(Object actual, Set<K> key) {
    // new StringBuilder to avoid "ToString.quote" in message formatting.. better solution ?
    super("\nExpecting:\n <%s>\nto contain key%s:\n <%s>", actual, new StringBuilder(key.size() == 1 ? "": "s"), new StringBuilder(Strings.join(key).with(", ", "'")));
  }
}
