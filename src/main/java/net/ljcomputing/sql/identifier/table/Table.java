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

package net.ljcomputing.sql.identifier.table;

import net.ljcomputing.sql.identifier.AbstractIdentifier;
import net.ljcomputing.sql.identifier.Alias;
import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;

/**
 * Table SQL identifier.
 * 
 * @author James G. Willmore
 *
 */
public class Table extends AbstractIdentifier implements Identifier, Alias {

  /** The alias. */
  private transient String alias;

  /**
   * Instantiates a new table.
   *
   * @param name the name
   */
  public Table(final String name) {
    super();
    this.name = name;
  }

  /**
   * Instantiates a new table.
   *
   * @param name the name
   * @param alias the alias
   */
  public Table(final String name, final String alias) {
    this(name);
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
   * @see net.ljcomputing.sql.identifier.Alias#as()
   */
  @SuppressWarnings({ "PMD.ShortMethodName" })
  public final String as() {
    final StringBuilder buf = new StringBuilder(name);

    if (alias != null && !"".equals(alias.trim())) {
      buf.append(Literal.Space.toString()).append(Keywords.As).append(Literal.Space.toString())
          .append(alias);
    }

    return buf.toString();
  }
}
