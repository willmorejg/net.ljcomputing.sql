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

package net.ljcomputing.sql.flyweight;

import java.util.Iterator;

import net.ljcomputing.sql.collection.ColumnCollection;
import net.ljcomputing.sql.collection.TableCollection;
import net.ljcomputing.sql.identifier.column.Column;
import net.ljcomputing.sql.identifier.table.Table;
import net.ljcomputing.sql.literal.Literal;
import net.ljcomputing.sql.visitor.ColumnAliasedAsVisitor;

/**
 * Table flyweight - 
 * creates a SQL fragment with the column alias prefixed with the table name
 * 
 * @author James G. Willmore
 *
 */
public class TableFlyweight {

  /** The column aliased as visitor. */
  private final transient ColumnAliasedAsVisitor colAsVisitor;

  /**
   * Instantiates a new table flyweight.
   */
  public TableFlyweight() {
    colAsVisitor = new ColumnAliasedAsVisitor();
  }

  /**
   * To SQL fragment.
   *
   * @param collection the collection
   * @return the string
   */
  public String toSql(final TableCollection collection) {
    final StringBuilder buf = new StringBuilder();
    final Iterator<Table> tabIt = collection.iterator();

    while (tabIt.hasNext()) {
      final Table table = tabIt.next();
      final String value = table.hasAlias() ? table.getAlias() : table.getName();
      final ColumnCollection cols = table.columns();
      final Iterator<Column> colIt = cols.iterator();

      while (colIt.hasNext()) {
        final Column col = colIt.next();
        final String colAlias = colAsVisitor.visit(col);
        buf.append(value).append(Literal.Period).append(colAlias);

        if (colIt.hasNext()) {
          buf.append(Literal.Comma).append(Literal.Space);
        }
      }

      if (tabIt.hasNext()) {
        buf.append(Literal.Comma).append(Literal.Space);
      }
    }

    return buf.toString();
  }
}
