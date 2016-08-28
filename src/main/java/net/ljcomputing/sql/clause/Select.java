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

import java.util.Iterator;

import net.ljcomputing.sql.buffer.ColumnBuffer;
import net.ljcomputing.sql.buffer.TableBuffer;
import net.ljcomputing.sql.identifier.column.Column;
import net.ljcomputing.sql.identifier.table.Table;
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

  /** The tables that are SELECTed. */
  private final transient TableBuffer tables;

  /**
   * Instantiates a new select clause.
   *
   * @param columns the columns
   */
  public Select(final Column... columns) {
    super();
    this.columns = new ColumnBuffer(columns);
    this.tables = new TableBuffer(columns);
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

  /**
   * Adds the tables.
   *
   * @param buf the buf
   */
  private final void addTables(final StringBuffer buf) {
    final Iterator<Table> iterator = tables.iterator();

    while (iterator.hasNext()) {
      final Table table = iterator.next();
      addTable(buf, table);

      if (iterator.hasNext()) {
        buf.append(Literal.Comma).append(Literal.Space);
      }
    }
  }
}
