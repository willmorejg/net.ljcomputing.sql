package net.ljcomputing.sql.collection;

import net.ljcomputing.sql.identifier.Identifier;

/**
 * SQL List.
 *
 * @param <T> the generic type
 */
public interface SqlList<T extends Identifier> extends SqlFragmentIterator<T> {

  /**
   * To SQL fragment.
   *
   * @return the string
   */
  String toSqlList();

  /**
   * Recurse the identifier and its children.
   *
   * @param result the result
   * @param parents the parents
   * @param identifier the identifier
   * @param addComma the add comma
   */
  void recurse(StringBuilder result, StringBuilder parents, Identifier identifier,
      boolean addComma);

  /**
   * Recurse children.
   *
   * @param result the result
   * @param parents the parents
   * @param identifier the identifier
   * @param idName the id name
   */
  void recurseChildren(StringBuilder result, StringBuilder parents, Identifier identifier,
      String idName);

}