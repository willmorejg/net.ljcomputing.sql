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

import net.ljcomputing.sql.identifier.column.Column;
import net.ljcomputing.sql.identifier.table.Table;

/**
 * Abstract implementation of a SQL clause.
 * 
 * @author James G. Willmore
 *
 */
@SuppressWarnings({ "PMD.AbstractClassWithoutAbstractMethod", "PMD.AtLeastOneConstructor" })
public abstract class AbstractClause {

  /**
   * Adds the table.
   *
   * @param buf the buf
   * @param table the table
   */
  public final void addTable(final StringBuffer buf, final Table table) {
    buf.append(table.as());
  }

  /**
   * Adds the column.
   *
   * @param buf the buf
   * @param column the column
   */
  public final void addColumn(final StringBuffer buf, final Column column) {
    buf.append(column.as());
  }

  /**
   * Adds the predicate.
   *
   * @param buf the buf
   * @param predicate the predicate
   */
  public final void addPredicate(final StringBuffer buf, final Predicate predicate) {
    buf.append(predicate.toString());
  }
}
