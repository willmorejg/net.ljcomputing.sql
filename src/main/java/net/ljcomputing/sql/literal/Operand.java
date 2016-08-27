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

package net.ljcomputing.sql.literal;

import net.ljcomputing.sql.keyword.Keywords;

/**
 * Enumeration of SQL operands.
 * 
 * @author James G. Willmore
 *
 */
public enum Operand {
  Equals(Literal.Equals.toString()),
  NotEqualTo(Literal.LessThan.toString() + Literal.GreaterThan.toString()),  
  GreaterThan(Literal.GreaterThan.toString()),
  LessThan(Literal.LessThan.toString()),
  GreaterThanEqualTo(Literal.GreaterThan + Literal.Equals.toString()),
  LessThanEqualTo(Literal.LessThan + Literal.Equals.toString()),
  Like(Keywords.Like.toString()),
  Between(Keywords.Between.toString())
  ;
  
  /** The value. */
  private String value;
  
  /**
   * Instantiates a new operand.
   *
   * @param value the value
   */
  private Operand(final String value) {
    this.value = value;
  }
  
  /**
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return value;
  }
}
