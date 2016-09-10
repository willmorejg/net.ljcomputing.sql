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

package net.ljcomputing.sql.collection;

import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.identifier.column.ColumnIdentifier;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;
import net.ljcomputing.sql.strategy.Function;

/**
 * SQL COLUMN collection.
 * 
 * @author James G. Willmore
 *
 */
public class ColumnCollection extends AbstractSqlList<ColumnIdentifier>
    implements SqlColumnList<ColumnIdentifier> {

  /**
   * Instantiates a new column collection.
   *
   * @param columns the columns
   */
  public ColumnCollection(final ColumnIdentifier... columns) {
    super(columns);
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlList
   *    #recurse(java.lang.StringBuilder, java.lang.StringBuilder, 
   *        net.ljcomputing.sql.identifier.Identifier, boolean)
   */
  @Override
  public final void recurse(final StringBuilder result, final StringBuilder parents,
      final Identifier identifier, final boolean addComma) {
    final ColumnIdentifier column = (ColumnIdentifier) identifier;
    wrapFunction(result, parents, column);
    addAlias(result, parents, column);

    if (addComma) {
      result.append(Literal.Comma).append(Literal.Space);
    }
  }
  
  /**
   * @see net.ljcomputing.sql.collection.SqlColumnList
   *    #wrapFunction(java.lang.StringBuilder, java.lang.StringBuilder, 
   *        net.ljcomputing.sql.identifier.column.ColumnIdentifier)
   */
  @Override
  public void wrapFunction(final StringBuilder result, final StringBuilder parents,
      final ColumnIdentifier column) {
    final String idName = column.getName();

    if (column.hasFunction()) {
      final StringBuilder value = parents.append(idName);
      final String idValue = value.toString();
      final Function function = column.getFunction();
      final String wrappedValue = function.toSql(idValue);
      result.append(wrappedValue);
    } else {
      result.append(parents).append(idName);
    }
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlColumnList
   *    #addAlias(java.lang.StringBuilder, java.lang.StringBuilder, 
   *        net.ljcomputing.sql.identifier.column.ColumnIdentifier)
   */
  @Override
  public void addAlias(final StringBuilder result, final StringBuilder parents,
      final ColumnIdentifier column) {
    if (column.hasAlias()) {
      final String alias = column.getAlias();
      result.append(Literal.Space).append(Keywords.As).append(Literal.Space).append(alias);
    }
  }

}
