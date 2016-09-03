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

package net.ljcomputing.sql.identifier;

import java.util.Objects;

/**
 * Abstract SQL identifier.
 * 
 * @author James G. Willmore
 *
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public abstract class AbstractIdentifier implements Identifier {

  /** The name of the identifier. */
  protected transient String name;

  /** The alias. */
  protected transient String alias;

  /**
   * Instantiates a new abstract identifier.
   *
   * @param name the name
   */
  public AbstractIdentifier(final String name) {
    this.name = name;
  }

  /**
   * Instantiates a new abstract identifier.
   *
   * @param name the name
   * @param alias the alias
   */
  public AbstractIdentifier(final String name, final String alias) {
    this(name);
    this.alias = alias;
  }

  /**
   * @see net.ljcomputing.sql.identifier.Identifier#getName()
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * @see net.ljcomputing.sql.identifier.Identifier#hasAlias()
   */
  public boolean hasAlias() {
    return alias != null && !"".equals(alias);
  }

  /**
   * @see net.ljcomputing.sql.identifier.Identifier#getAlias()
   */
  public String getAlias() {
    return alias;
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, alias);
  }

  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings("PMD.DataflowAnomalyAnalysis")
  @Override
  public boolean equals(final Object obj) {
    boolean result = false;

    if (obj != null && getClass() == obj.getClass()) {
      final AbstractIdentifier other = (AbstractIdentifier) obj;

      result = Objects.equals(name, other.name);
      result = result && Objects.equals(alias, other.alias);
    }

    return result;
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "AbstractIdentifier [name=" + name + ", alias=" + alias + "]";
  }
}
