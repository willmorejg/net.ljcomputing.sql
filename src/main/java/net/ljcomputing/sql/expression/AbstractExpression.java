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

package net.ljcomputing.sql.expression;

import net.ljcomputing.sql.identifier.Column;
import net.ljcomputing.sql.literal.Operand;

/**
 * Abstract implementation of a SQL expression.
 * 
 * @author James G. Willmore
 *
 */
public abstract class AbstractExpression implements Expression {

  /** The column. */
  protected final transient Column column;

  /** The operand. */
  protected final transient Operand operand;

  /**
   * Instantiates a new abstract expression.
   *
   * @param column the column
   * @param operand the operand
   */
  public AbstractExpression(final Column column, final Operand operand) {
    this.column = column;
    this.operand = operand;
  }

  /**
   * Gets the column portion of the expression (left hand side of operation).
   *
   * @return the column
   */
  public Column getColumn() {
    return column;
  }

  /**
   * Gets the SQL operand.
   *
   * @return the operand
   */
  public Operand getOperand() {
    return operand;
  }
}
