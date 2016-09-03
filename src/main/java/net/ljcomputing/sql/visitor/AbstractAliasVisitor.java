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

import net.ljcomputing.sql.collection.SqlFragmentCollection;
import net.ljcomputing.sql.flyweight.Alias;
import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.literal.Literal;

/**
 * Visitor that visits each identifier, and produces the appropriate ALIAS.
 * 
 * @author James G. Willmore
 *
 */
public abstract class AbstractAliasVisitor<T extends Identifier, C extends SqlFragmentCollection<T>, S extends Alias<T>>
    implements SqlVisitor<T, C> {

  /** The alias type. */
  protected transient S aliasType;

  /**
   * Instantiates a new alias visitor.
   *
   * @param aliasType the alias type
   */
  public AbstractAliasVisitor(final S aliasType) {
    this.aliasType = aliasType;
  }

  /**
   * @see net.ljcomputing.sql.visitor.SqlVisitor#visit(java.lang.Object)
   */
  @Override
  public String visit(final T identifier) {
    final StringBuilder buf = new StringBuilder();
    final String aliases = aliasType.toSql(identifier);
    buf.append(aliases);
    return buf.toString();
  }

  /**
   * @see net.ljcomputing.sql.visitor.SqlVisitor
   *    #visit(net.ljcomputing.sql.collection.SqlFragmentCollection)
   */
  @Override
  public String visit(final SqlFragmentCollection<T> collection) {
    final StringBuilder buf = new StringBuilder();
    final Iterator<T> iterator = collection.iterator();

    while (iterator.hasNext()) {
      final T identifier = iterator.next();
      final String value = visit(identifier);
      buf.append(value);

      if (iterator.hasNext()) {
        buf.append(Literal.Comma).append(Literal.Space);
      }
    }

    return buf.toString();
  }
}
