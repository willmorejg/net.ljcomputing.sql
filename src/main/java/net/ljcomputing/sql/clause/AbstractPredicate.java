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

import net.ljcomputing.sql.expression.Expression;
import net.ljcomputing.sql.identifier.Column;
import net.ljcomputing.sql.identifier.Table;
import net.ljcomputing.sql.literal.Conjunction;
import net.ljcomputing.sql.literal.Literal;
import net.ljcomputing.sql.literal.Operand;

/**
 * Abstract implementation of a predicate clause.
 * 
 * @author James G. Willmore
 *
 */
public abstract class AbstractPredicate implements Predicate {

  /** The expression. */
  private final transient Expression expression;

  /** The value. */
  private final transient Object value;

  /** The conjunction. */
  private transient Conjunction conjunction;

  /**
   * Instantiates a new predicate.
   *
   * @param expression the expression
   * @param value the value
   */
  public AbstractPredicate(final Expression expression, final Object value) {
    this.expression = expression;
    this.value = value;
  }

  /**
   * Instantiates a new abstract predicate.
   *
   * @param expression the expression
   * @param value the value
   * @param conjunction the conjunction
   */
  public AbstractPredicate(final Expression expression, final Object value,
      final Conjunction conjunction) {
    this(expression, value);
    this.conjunction = conjunction;
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public final String toString() {
    final StringBuffer buf = new StringBuffer();
    final Column column = expression.getColumn();
    final String columnName = column.getName();
    final Table table = column.getTable();
    final String columnAlias = table.getAlias();
    final Operand operand = expression.getOperand();

    if (columnAlias != null) {
      buf.append(columnAlias).append(Literal.Period);
    }

    buf.append(columnName).append(operand.toString());

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
  public Conjunction getConjunction() {
    return conjunction;
  }

  /**
   * Checks for a conjunction.
   *
   * @return true, if successful
   */
  public boolean hasConjunction() {
    return conjunction != null;
  }
}
