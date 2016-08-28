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

package net.ljcomputing.sql.buffer;

import net.ljcomputing.sql.identifier.column.Column;
import net.ljcomputing.sql.identifier.table.Table;

/**
 * SQL TABLE buffer.
 * 
 * @author James G. Willmore
 *
 */
public class TableBuffer extends AbstractSqlBuffer<Table> implements SqlBuffer<Table> {

  /**
   * Instantiates a new table buffer.
   *
   * @param tables the tables
   */
  public TableBuffer(final Table... tables) {
    super(tables);
  }

  /**
   * Instantiates a new table buffer.
   *
   * @param columns the columns
   */
  public TableBuffer(final Column... columns) {
    super();

    for (final Column column : columns) {
      final Table table = column.getTable();

      if (!contains(table)) {
        add(table);
      }
    }
  }
}
