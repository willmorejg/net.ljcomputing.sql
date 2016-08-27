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

/**
 * Class containing SQL literal characters (ex. semicolon).
 * 
 * @author James G. Willmore
 *
 */
public enum Literal {
  Space(' '),
  LeftParen('('),
  RightParen(')'),
  DoubleQuote('"'),
  SingleQuote('\''),
  Percent('%'),
  Ampersand('&'),
  Asterisk('*'),
  Slash('/'),
  Plus('+'),
  Minus('-'),
  Comma(','),
  Period('.'),
  Colon(':'),
  SemiColon(';'),
  LessThan('<'),
  GreaterThan('>'),
  Question('?'),
  LeftBracket('['),
  RightBracket(']'),
  Underline('_'),
  VerticalBar('|'),
  Equals('='),
  LeftBrace('{'),
  RightBrace('}'),
  Circumflex('^');
  
  /** The value. */
  private final char value;
  
  /**
   * Instantiates a new literal.
   *
   * @param value the value
   */
  private Literal(final char value) {
    this.value = value;
  }
  
  /**
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
