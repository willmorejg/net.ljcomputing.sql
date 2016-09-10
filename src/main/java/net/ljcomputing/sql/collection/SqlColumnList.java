package net.ljcomputing.sql.collection;

import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.identifier.column.ColumnIdentifier;

/**
 * SQL Column List.
 *
 * @param <T> the generic type
 */
public interface SqlColumnList<T extends Identifier> extends SqlList<T> {

  /**
   * Wrap column identifier value in the assigned function.
   *
   * @param result the result
   * @param parents the parents
   * @param column the column
   */
  void wrapFunction(StringBuilder result, StringBuilder parents, ColumnIdentifier column);

  /**
   * Adds the alias.
   *
   * @param result the result
   * @param parents the parents
   * @param column the column
   */
  void addAlias(StringBuilder result, StringBuilder parents, ColumnIdentifier column);

}