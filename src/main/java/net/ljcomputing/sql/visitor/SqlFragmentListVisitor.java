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

package net.ljcomputing.sql.visitor;

import java.util.Iterator;

import net.ljcomputing.sql.collection.ColumnCollection;
import net.ljcomputing.sql.collection.SqlFragmentCollection;
import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.identifier.column.ColumnIdentifier;
import net.ljcomputing.sql.identifier.schema.SchemaIdentifier;
import net.ljcomputing.sql.identifier.table.TableIdentifier;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;
import net.ljcomputing.sql.strategy.Function;

/**
 * @author James G. Willmore
 *
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class SqlFragmentListVisitor implements DottedVisitor {

  /**
   * @see net.ljcomputing.sql.visitor.DottedVisitor
   *    #toSqlFragment(net.ljcomputing.sql.identifier.schema.SchemaIdentifier)
   */
  @Override
  public String toSqlFragment(final SchemaIdentifier schema) {
    final StringBuilder buf = new StringBuilder();
    recurse(buf, new StringBuilder(), schema, false);
    return buf.toString();
  }

  /**
   * @see net.ljcomputing.sql.visitor.DottedVisitor
   *    #toSqlFragment(net.ljcomputing.sql.identifier.table.TableIdentifier)
   */
  @Override
  public String toSqlFragment(final TableIdentifier table) {
    final StringBuilder buf = new StringBuilder();
    recurse(buf, new StringBuilder(), table, false);
    return buf.toString();
  }

  /**
   * @see net.ljcomputing.sql.visitor.DottedVisitor
   *    #toSqlFragment(net.ljcomputing.sql.identifier.column.ColumnIdentifier)
   */
  @Override
  public String toSqlFragment(final ColumnIdentifier column) {
    final StringBuilder buf = new StringBuilder();
    recurse(buf, new StringBuilder(), column, false);
    return buf.toString();
  }
  
  /**
   * @see net.ljcomputing.sql.visitor.DottedVisitor
   *    #toSqlFragment(net.ljcomputing.sql.collection.ColumnCollection)
   */
  public String toSqlFragment(final ColumnCollection identifiers) {
    final StringBuilder buf = new StringBuilder();
    final Iterator<ColumnIdentifier> columnIt = identifiers.iterator();
    
    while (columnIt.hasNext()) {
      final ColumnIdentifier column = columnIt.next();
      final boolean hasNext = columnIt.hasNext();
      recurse(buf, new StringBuilder(), column, hasNext);
    }

    return buf.toString();
  }

  /**
   * Recurse the identifier and its children.
   *
   * @param result the result
   * @param parents the parents
   * @param identifier the identifier
   * @param addComma the add comma
   */
  private final void recurse(final StringBuilder result, final StringBuilder parents,
      final Identifier identifier, final boolean addComma) {
    final String idName = identifier.getName();

    if (identifier.hasChildren()) {
      recurseChildren(result, parents, identifier, idName);
    } else {
      if (identifier instanceof ColumnIdentifier) {
        final ColumnIdentifier column = (ColumnIdentifier) identifier;
        wrapFunction(result, parents, column);
        addAlias(result, parents, column);
      } else {
        result.append(parents).append(idName);
      }

      if (addComma) {
        result.append(Literal.Comma).append(Literal.Space);
      }
    }
  }

  /**
   * Recurse children.
   *
   * @param result the result
   * @param parents the parents
   * @param identifier the identifier
   * @param idName the id name
   */
  private void recurseChildren(final StringBuilder result, final StringBuilder parents,
      final Identifier identifier, final String idName) {
    final SqlFragmentCollection<? extends Identifier> children = identifier.getChildren();
    final Iterator<? extends Identifier> idIt = (Iterator<? extends Identifier>) children
        .iterator();

    parents.append(idName).append(Literal.Period);

    while (idIt.hasNext()) {
      final Identifier child = idIt.next();
      final boolean hasNext = idIt.hasNext();
      recurse(result, parents, child, hasNext);
    }
  }

  /**
   * Wrap column identifier value in the assigned function.
   *
   * @param result the result
   * @param parents the parents
   * @param column the column
   */
  private void wrapFunction(final StringBuilder result, final StringBuilder parents,
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
   * Adds the alias.
   *
   * @param result the result
   * @param parents the parents
   * @param column the column
   */
  private void addAlias(final StringBuilder result, final StringBuilder parents,
      final ColumnIdentifier column) {
    if (column.hasAlias()) {
      final String alias = column.getAlias();
      result.append(Literal.Space).append(Keywords.As).append(Literal.Space).append(alias);
    }
  }
}
