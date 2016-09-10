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
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;
import net.ljcomputing.sql.literal.Operand;

/**
 * Equals expression.
 * 
 * @author James G. Willmore
 *
 */
public class EqualsExpression extends AbstractExpression {
  
  /**
   * Instantiates a new equals expression.
   *
   * @param identifier the identifier
   * @param values the values
   */
  public EqualsExpression(final Identifier identifier, final Object ... values) {
    super(identifier, Operand.Equals, values);
  }

  /**
   * To SQL.
   *
   * @return the string
   */
  public String toSql() {
    final String id = getIdentifier();
    final String op = getOperand();
    final StringBuilder buf = new StringBuilder();
    
    for (int v = 0; v < getValues().length; v++) {
      final Object value = getValues()[v];

      buf.append(id);

      if (value != null) {
        buf.append(op);
        final String valueStr = value.toString();
        
        buf.append(Literal.SingleQuote).append(valueStr).append(Literal.SingleQuote);
      } else {
        buf.append(Literal.Space).append(Keywords.Is).append(Literal.Space).append(Keywords.Null);
      }
      
      if (v+1 != getValues().length) {
        buf.append(Literal.Comma).append(Literal.Space);
      }
    } 

    return buf.toString();
  }
}
