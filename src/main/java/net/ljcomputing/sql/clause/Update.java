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

import net.ljcomputing.sql.identifier.Table;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;

/**
 * SQL UPDATE clause.
 * 
 * @author James G. Willmore
 *
 */
public class Update extends AbstractClause implements Clause {

  /** The table. */
  private final transient Table table;

  /**
   * Instantiates a new update clause.
   *
   * @param table the table
   */
  public Update(final Table table) {
    super();
    this.table = table;
  }

  /**
   * @see net.ljcomputing.sql.clause.Clause#toClause()
   */
  @Override
  public String toClause() {
    final StringBuffer buf = new StringBuffer(Keywords.Update.toString()).append(Literal.Space);
    final String name = table.getName();

    buf.append(name).append(Literal.Space);

    return buf.toString();
  }

}
