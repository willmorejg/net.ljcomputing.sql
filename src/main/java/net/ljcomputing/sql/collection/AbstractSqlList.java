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

import java.util.Iterator;

import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.literal.Literal;

/**
 * Abstract implementation of a SQL list.
 * 
 * @author James G. Willmore
 *
 */
public abstract class AbstractSqlList<T extends Identifier> extends AbstractSqlFragmentCollection<T> implements SqlList<T> {
 
  /**
   * Instantiates a new abstract sql list.
   *
   * @param elements the elements
   */
  public AbstractSqlList(@SuppressWarnings("unchecked") final T... elements) {
    super(elements);
  }
  
  /**
   * @see net.ljcomputing.sql.collection.SqlList
   *    #createSql(net.ljcomputing.sql.identifier.Identifier)
   */
  @Override
  public String toSqlList() {
    final StringBuilder buf = new StringBuilder();

    iterator();
    
    while (hasNext()) {
      final StringBuilder parents = new StringBuilder();
      recurse(buf, parents, next(), false);
      
      if(hasNext()) {
        buf.append(Literal.Comma);
      }
      
      buf.append(Literal.Space);
    }

    return buf.toString();
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlList
   *    #recurse(java.lang.StringBuilder, java.lang.StringBuilder, 
   *        net.ljcomputing.sql.identifier.Identifier, boolean)
   */
  @Override
  public void recurse(final StringBuilder result, final StringBuilder parents,
      final Identifier identifier, final boolean addComma) {
    final String idName = identifier.getName();

    if (identifier.hasChildren()) {
      recurseChildren(result, parents, identifier, idName);
    } else {
      result.append(parents).append(idName);

      if (addComma) {
        result.append(Literal.Comma).append(Literal.Space);
      }
    }
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlList
   *    #recurseChildren(java.lang.StringBuilder, java.lang.StringBuilder, 
   *        net.ljcomputing.sql.identifier.Identifier, java.lang.String)
   */
  @Override
  public void recurseChildren(final StringBuilder result, final StringBuilder parents,
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

}
