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

package net.ljcomputing.sql.identifier.table;

import net.ljcomputing.sql.collection.ColumnCollection;
import net.ljcomputing.sql.identifier.AbstractIdentifier;
import net.ljcomputing.sql.identifier.Identifier;

/**
 * Table SQL identifier.
 * 
 * @author James G. Willmore
 *
 */
public class Table extends AbstractIdentifier implements Identifier {

  /** The alias. */
  protected transient String alias;

  /** The column buffer. */
  protected transient ColumnCollection columnCollection;

  /**
   * Instantiates a new table.
   *
   * @param name the name
   * @param columnCollection the column collection
   */
  public Table(final String name, final ColumnCollection columnCollection) {
    this(name, null, columnCollection);
  }

  /**
   * Instantiates a new table.
   *
   * @param name the name
   * @param alias the alias
   * @param columnCollection the column collection
   */
  public Table(final String name, final String alias, final ColumnCollection columnCollection) {
    super(name, alias);
    this.columnCollection = columnCollection;
  }

  /**
   * Columns.
   *
   * @return the column collection
   */
  public ColumnCollection columns() {
    return columnCollection;
  }
}
