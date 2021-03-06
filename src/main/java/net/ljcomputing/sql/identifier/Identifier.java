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

import net.ljcomputing.sql.collection.SqlFragmentCollection;

/**
 * Interface shared by all SQL identifier implementations.
 * 
 * @author James G. Willmore
 *
 */
public interface Identifier {

  /**
   * Gets the name of the identifier.
   *
   * @return the name
   */
  String getName();

  /**
   * Checks for alias.
   *
   * @return true, if successful
   */
  boolean hasAlias();

  /**
   * Gets the alias.
   *
   * @return the alias
   */
  String getAlias();

  /**
   * Indicates if the identifier has child identifiers.
   *
   * @return true, if successful
   */
  boolean hasChildren();

  /**
   * Gets the child identifiers.
   *
   * @return the children
   */
  SqlFragmentCollection<? extends Identifier> getChildren();
}
