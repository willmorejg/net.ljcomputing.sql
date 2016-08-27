/**
           Copyright 2016, James G. Willmore

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package net.ljcomputing.sql.clause;

import net.ljcomputing.sql.expression.EqualsExpression;
import net.ljcomputing.sql.identifier.Column;
import net.ljcomputing.sql.literal.Conjunction;

/**
 * Equals predicate implementation.
 * 
 * @author James G. Willmore
 *
 */
public class EqualsPredicate extends AbstractPredicate implements Predicate {

  /**
   * Instantiates a new equals predicate.
   *
   * @param column the column
   */
  public EqualsPredicate(final Column column, final Object value) {
    super(new EqualsExpression(column), value);
  }

  /**
   * Instantiates a new equals predicate.
   *
   * @param column the column
   * @param value the value
   * @param conjunction the conjunction
   */
  public EqualsPredicate(final Column column, final Object value, final Conjunction conjunction) {
    super(new EqualsExpression(column), value, conjunction);
  }
}
