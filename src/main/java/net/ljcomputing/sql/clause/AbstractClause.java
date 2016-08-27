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

import net.ljcomputing.sql.identifier.Column;
import net.ljcomputing.sql.identifier.Table;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;

/**
 * Abstract implementation of a SQL clause.
 * 
 * @author James G. Willmore
 *
 */
@SuppressWarnings({"PMD.AbstractClassWithoutAbstractMethod", "PMD.AtLeastOneConstructor"})
public abstract class AbstractClause {

  /**
   * Adds the table.
   *
   * @param buf the buf
   * @param table the table
   */
  public void addTable(final StringBuffer buf, final Table table) {
    final String name = table.getName();
    final String alias = table.getAlias();

    buf.append(name);

    if (alias != null) {
      buf.append(Literal.Space).append(alias);
    }

  }

  /**
   * Adds the column.
   *
   * @param buf the buf
   * @param column the column
   */
  public void addColumn(final StringBuffer buf, final Column column) {
    final Table table = column.getTable();
    final String tableAlias = table.getAlias();
    final String name = column.getName();
    final String alias = column.getAlias();

    if (tableAlias != null) {
      buf.append(tableAlias).append(Literal.Period);
    }

    buf.append(name);

    if (alias != null) {
      buf.append(Literal.Space).append(Keywords.As).append(Literal.Space).append(alias);
    }
  }

  /**
   * Adds the predicate.
   *
   * @param buf the buf
   * @param predicate the predicate
   */
  public void addPredicate(final StringBuffer buf, final Predicate predicate) {
    buf.append(predicate.toString());
  }
}
