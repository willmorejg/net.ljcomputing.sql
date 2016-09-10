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

package net.ljcomputing.sql.identifier.schema;

import net.ljcomputing.sql.collection.SqlFragmentCollection;
import net.ljcomputing.sql.collection.TableCollection;
import net.ljcomputing.sql.identifier.AbstractIdentifier;
import net.ljcomputing.sql.identifier.Identifier;

/**
 * Schema SQL identifier.
 * 
 * @author James G. Willmore
 *
 */
public class SchemaIdentifier extends AbstractIdentifier implements Identifier {

  /** The column buffer. */
  private transient TableCollection tableCollection;

  /**
   * Instantiates a new schema.
   *
   * @param name the name
   * @param tableCollection the column collection
   */
  public SchemaIdentifier(final String name, final TableCollection tableCollection) {
    this(name, null, tableCollection);
  }

  /**
   * Instantiates a new table.
   *
   * @param name the name
   * @param alias the alias
   * @param tableCollection the column collection
   */
  public SchemaIdentifier(final String name, final String alias,
      final TableCollection tableCollection) {
    super(name, alias);
    this.tableCollection = tableCollection;
  }

  /**
   * Tables.
   *
   * @return the table collection
   */
  public TableCollection tables() {
    return tableCollection;
  }

  /**
   * @see net.ljcomputing.sql.identifier.AbstractIdentifier#hasChildren()
   */
  @Override
  public boolean hasChildren() {
    return true;
  }

  /**
   * @see net.ljcomputing.sql.identifier.AbstractIdentifier#getChildren()
   */
  @Override
  public SqlFragmentCollection<? extends Identifier> getChildren() {
    return tableCollection;
  }
}
