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
   * SQL predicate.
   *
   * @return the string
   */
  public final String toPredicate() {
    final StringBuffer buf = new StringBuffer();
    final Column column = expression.getColumn();
    final String columnName = column.getName();
    final String columnAlias = column.getAlias();
    final Operand operand = expression.getOperand();
    String valueStr = null;

    if (value != null) {
      valueStr = value.toString();
    }

    if (columnAlias != null) {
      buf.append(columnAlias).append(Literal.Period);
    }
    
    buf.append(columnName).append(operand.toString()).append(valueStr);
    
    return buf.toString();
  }
}
