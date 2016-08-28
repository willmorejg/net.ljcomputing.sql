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

import net.ljcomputing.sql.identifier.Alias;
import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.identifier.table.Table;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;

/**
 * All COLUMNs from given TABLE SQL identifier. 
 * For example: SELECT T.* FROM TABLE T
 * 
 * @author James G. Willmore
 *
 */
public class AllColumns extends Column implements Identifier, Alias {

  /**
   * Instantiates a new column.
   *
   * @param table the table
   */
  public AllColumns(final Table table) {
    super(table, Literal.Asterisk.toString());
  }

  /**
   * Instantiates a new column.
   *
   * @param table the table
   * @param alias the alias
   */
  public AllColumns(final Table table, final String alias) {
    super(table, Literal.Asterisk.toString(), alias);
  }

  /**
   * @see net.ljcomputing.sql.identifier.Alias#as()
   */
  @Override
  public final String as() {
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
}
