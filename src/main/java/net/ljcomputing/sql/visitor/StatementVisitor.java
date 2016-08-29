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

package net.ljcomputing.sql.visitor;

import net.ljcomputing.sql.statement.Statement;

/**
 * @author James G. Willmore
 *
 */
@SuppressWarnings({ "PMD.AtLeastOneConstructor" })
public class StatementVisitor implements Visitor<Statement> {

  /**
   * @see net.ljcomputing.sql.visitor.Visitor
   * #visit(java.lang.StringBuffer, java.lang.Object)
   */
  @Override
  public void visit(final StringBuffer buf, final Statement element) {
    buf.append(element);
  }

}
