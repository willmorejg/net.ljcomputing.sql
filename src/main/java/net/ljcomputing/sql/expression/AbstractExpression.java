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

import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.literal.Operand;

/**
 * Abstract implementation of a SQL expression.
 * 
 * @author James G. Willmore
 *
 */
public abstract class AbstractExpression implements Expression {
  
  /** The identifier. */
  private final Identifier identifier;
  
  /** The operand. */
  private final Operand operand;
  
  /** The values. */
  private final Object[] values;
  
  /**
   * Instantiates a new abstract expression.
   *
   * @param identifier the identifier
   * @param operand the operand
   * @param values the values
   */
  public AbstractExpression(final Identifier identifier, final Operand operand, final Object ... values) {
    this.identifier = identifier;
    this.operand = operand;
    this.values = values;
  }

  /**
   * @see net.ljcomputing.sql.expression.Expression#getIdentifier()
   */
  @Override
  public String getIdentifier() {
    final String result;
    
    if(identifier.hasAlias()) {
      result = identifier.getAlias();
    } else {
      result = identifier.getName();
    }
    
    return result;
  }

  /**
   * @see net.ljcomputing.sql.expression.Expression#getOperand()
   */
  @Override
  public String getOperand() {
    return operand.toString();
  }

  /**
   * @see net.ljcomputing.sql.expression.Expression#getValues()
   */
  @Override
  public Object[] getValues() {
    return values;
  }
}
