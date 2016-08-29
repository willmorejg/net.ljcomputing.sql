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

package net.ljcomputing.sql.statement;

import net.ljcomputing.sql.clause.Delete;
import net.ljcomputing.sql.clause.Where;
import net.ljcomputing.sql.identifier.table.Table;

/**
 * SQL DELETE statement implementation.
 * 
 * @author James G. Willmore
 *
 */
public class DeleteStatement implements Statement {

  /** The delete clause. */
  private final transient Delete delete;

  /** The predicates clauses. */
  private transient Where whereClause;

  /**
   * Instantiates a new select statement.
   *
   * @param columns the columns
   */
  public DeleteStatement(final Table table) {
    delete = new Delete(table);
  }

  /**
   * Add WHERE clause to SELECT statement.
   *
   * @param whereClause the where clause
   */
  public void where(final Where whereClause) {
    this.whereClause = whereClause;
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    final StringBuffer buf = new StringBuffer(delete.toString());

    if (whereClause != null) {
      buf.append(whereClause.toString());
    }

    return buf.toString();
  }
}
