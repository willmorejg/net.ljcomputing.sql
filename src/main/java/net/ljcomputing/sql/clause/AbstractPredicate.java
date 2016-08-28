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

import net.ljcomputing.sql.identifier.column.Column;
import net.ljcomputing.sql.literal.Conjunction;
import net.ljcomputing.sql.literal.Operand;

/**
 * Abstract implementation of a predicate clause.
 * 
 * @author James G. Willmore
 *
 */
public abstract class AbstractPredicate implements Predicate {

  /** The column. */
  private final transient Column column;

  /** The operand. */
  private final transient Operand operand;

  /** The value. */
  private final transient Object value;

  /** The conjunction. */
  private final transient Conjunction conjunction;

  /**
   * Instantiates a new predicate.
   *
   * @param column the column
   * @param operand the operand
   * @param value the value
   * @param conjunction the conjunction
   */
  public AbstractPredicate(final Column column, final Operand operand, final Object value,
      final Conjunction conjunction) {
    this.column = column;
    this.operand = operand;
    this.value = value;
    this.conjunction = conjunction;
  }

  /**
   * Instantiates a new abstract predicate.
   *
   * @param column the column
   * @param operand the operand
   * @param value the value
   */
  public AbstractPredicate(final Column column, final Operand operand, final Object value) {
    this(column, operand, value, null);
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    final StringBuffer buf = new StringBuffer();
    final String columnAlias = column.aliased();

    buf.append(columnAlias).append(operand);

    if (value != null) {
      buf.append(value.toString());
    }

    return buf.toString();
  }

  /**
   * Gets the conjunction.
   *
   * @return the conjunction
   */
  @Override
  public final Conjunction getConjunction() {
    return conjunction;
  }

  /**
   * Checks for a conjunction.
   *
   * @return true, if successful
   */
  @Override
  public final boolean hasConjunction() {
    return conjunction != null;
  }
}
