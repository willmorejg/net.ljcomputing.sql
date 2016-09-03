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

package net.ljcomputing.sql.flyweight;

import java.util.Iterator;

import net.ljcomputing.sql.collection.SqlFragmentCollection;
import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.literal.Literal;

/**
 * @author James G. Willmore
 *
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class DottedAlias<T extends Identifier> implements Alias<T> {

  /**
   * @see net.ljcomputing.sql.flyweight.Alias#toSql(java.lang.Object)
   */
  public String toSql(final T identifier) {
    final StringBuilder buf = new StringBuilder();

    if (identifier != null && identifier.hasAlias()) {
      final String alias = identifier.getAlias();
      buf.append(alias).append(Literal.Period);
    }

    buf.append(identifier.getName());

    return buf.toString();
  }

  /**
   * @see net.ljcomputing.sql.flyweight.Alias
   *    #toSql(net.ljcomputing.sql.collection.SqlFragmentCollection)
   */
  @Override
  public String toSql(final SqlFragmentCollection<T> collection) {
    final StringBuilder buf = new StringBuilder();
    final Iterator<T> iterator = collection.iterator();

    while (iterator.hasNext()) {
      final T identifier = iterator.next();
      final String value = toSql(identifier);

      buf.append(value);

      if (iterator.hasNext()) {
        buf.append(Literal.Comma).append(Literal.Space);
      }
    }

    return buf.toString();
  }
}
