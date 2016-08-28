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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.ljcomputing.sql.buffer.ColumnBuffer;
import net.ljcomputing.sql.identifier.Column;
import net.ljcomputing.sql.identifier.Table;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;

/**
 * SQL SELECT clause.
 * 
 * @author James G. Willmore
 *
 */
public class Select extends AbstractClause implements Clause {

  /** The columns that are SELECTed. */
  private final transient ColumnBuffer columns;

  /**
   * Instantiates a new select clause.
   *
   * @param columns the columns
   */
  public Select(final Column... columns) {
    super();
    this.columns = new ColumnBuffer(columns);
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    final StringBuffer buf = new StringBuffer(Keywords.Select.toString()).append(Literal.Space);
    addColumns(buf);
    buf.append(Keywords.From.toString()).append(Literal.Space);
    addTables(buf);
    buf.append(Literal.Space);
    return buf.toString();
  }

  /**
   * Adds the columns to the SELECT clause.
   *
   * @param buf the buf
   */
  private final void addColumns(final StringBuffer buf) {
    if (columns.isEmpty()) {
      buf.append(Literal.Asterisk);
    }

    if (!columns.isEmpty()) {
      final Iterator<Column> iterator = columns.iterator();

      while (iterator.hasNext()) {
        final Column column = iterator.next();
        addColumn(buf, column);

        if (iterator.hasNext()) {
          buf.append(Literal.Comma);
        }

        buf.append(Literal.Space);
      }
    }
  }

  /**
   * Adds the tables.
   *
   * @param buf the buf
   */
  private final void addTables(final StringBuffer buf) {
    final Set<Table> tables = getSelectedTables();
    final Iterator<Table> iterator = tables.iterator();
    while (iterator.hasNext()) {
      final Table table = iterator.next();
      addTable(buf, table);

      if (iterator.hasNext()) {
        buf.append(Literal.Comma).append(Literal.Space);
      }
    }
  }

  /**
   * Gets the selected tables.
   *
   * @return the selected tables
   */
  private final Set<Table> getSelectedTables() {
    final Set<Table> tables = new HashSet<Table>();

    for (final Column column : columns) {
      final Table table = column.getTable();
      tables.add(table);
    }

    return tables;
  }
}
