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

package net.ljcomputing.sql.identifier.column;

import net.ljcomputing.sql.identifier.AbstractIdentifier;
import net.ljcomputing.sql.identifier.Alias;
import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.identifier.table.Table;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;

/**
 * Column SQL identifier.
 * 
 * @author James G. Willmore
 *
 */
public class Column extends AbstractIdentifier implements Identifier, Alias {

  /** The table associated with the given column. */
  protected final transient Table table;

  /** The name of the table associated with the given column. */
  protected final transient String tableName;

  /** The alias of the table associated with the given column. */
  protected final transient String tableAlias;

  /** The alias. */
  protected transient String alias;

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
    this.tableName = this.table.getName();
    this.tableAlias = this.table.getAlias();
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

  /**
   * @see net.ljcomputing.sql.identifier.Alias#as()
   */
  public String as() {
    final StringBuilder buf = new StringBuilder();
    final boolean hasTableName = tableName != null && !"".equals(tableName.trim());
    final boolean hasTableAlias = tableAlias != null && !"".equals(tableAlias.trim());
    final boolean hasAlias = alias != null && !"".equals(alias.trim());

    if (hasTableAlias) {
      buf.append(tableAlias).append(Literal.Period.toString());
    } else if (hasTableName) {
      buf.append(tableName).append(Literal.Period.toString());
    }

    buf.append(name);

    if (hasAlias) {
      buf.append(Literal.Space.toString()).append(Keywords.As).append(Literal.Space.toString())
          .append(alias);
    }

    return buf.toString();
  }

  /**
   * Create a SQL fragment of the column with the alias separated by a comma. 
   * For example: COLUMN_ALIAS.COLUMN_NAME
   *
   * @return the string
   */
  public String aliased() {
    final StringBuilder buf = new StringBuilder();

    if (alias != null && !"".equals(alias.trim())) {
      buf.append(alias).append(Literal.Period.toString());
    }

    buf.append(name);

    return buf.toString();
  }
}
