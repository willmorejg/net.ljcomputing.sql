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

package net.ljcomputing.sql.identifier;

/**
 * Column SQL identifier.
 * 
 * @author James G. Willmore
 *
 */
public class Column extends AbstractIdentifier implements Identifier, Alias {

  /** The table associated with the given column. */
  private final transient Table table;

  /** The alias. */
  private transient String alias;

  /**
   * Instantiates a new column.
   *
   * @param table the table
   * @param name the name
   */
  public Column(final Table table, final String name) {
    super();
    this.table = table;
    this.name = name;
  }

  /**
   * Instantiates a new column.
   *
   * @param table the table
   * @param name the name
   * @param alias the alias
   */
  public Column(final Table table, final String name, final String alias) {
    this(table, name);
    this.alias = alias;
  }

  /**
   * @see net.ljcomputing.sql.identifier.Alias#getAlias()
   */
  @Override
  public final String getAlias() {
    return alias;
  }

  /**
   * Gets the table associated with the given column.
   *
   * @return the table
   */
  public Table getTable() {
    return table;
  }
}
