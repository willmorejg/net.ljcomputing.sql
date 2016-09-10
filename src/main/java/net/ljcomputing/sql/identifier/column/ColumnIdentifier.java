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

import net.ljcomputing.sql.collection.SqlFragmentCollection;
import net.ljcomputing.sql.identifier.AbstractIdentifier;
import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.strategy.FunctionStrategy;

/**
 * Column SQL identifier.
 * 
 * @author James G. Willmore
 *
 */
public class ColumnIdentifier extends AbstractIdentifier implements Identifier, Column {

  /** The function. */
  private transient FunctionStrategy function;

  /**
   * Instantiates a new column.
   *
   * @param name the name
   */
  public ColumnIdentifier(final String name) {
    super(name);
  }

  /**
   * Instantiates a new column.
   *
   * @param name the name
   * @param alias the alias
   */
  public ColumnIdentifier(final String name, final String alias) {
    super(name, alias);
  }

  /**
   * @see net.ljcomputing.sql.identifier.column.Column
   *    #setFunction(net.ljcomputing.sql.strategy.FunctionStrategy)
   */
  @Override
  public void setFunction(final FunctionStrategy function) {
    this.function = function;
  }

  /**
   * @see net.ljcomputing.sql.identifier.column.Column#hasFunction()
   */
  @Override
  public boolean hasFunction() {
    return function != null;
  }

  /**
   * @see net.ljcomputing.sql.identifier.column.Column#getFunction()
   */
  public FunctionStrategy getFunction() {
    return function;
  }

  /**
   * @see net.ljcomputing.sql.identifier.AbstractIdentifier#hasChildren()
   */
  @Override
  public boolean hasChildren() {
    return false;
  }

  /**
   * @see net.ljcomputing.sql.identifier.AbstractIdentifier#getChildren()
   */
  @Override
  public SqlFragmentCollection<? extends Identifier> getChildren() {
    return null;
  }
}
