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

import net.ljcomputing.sql.collection.SqlFragmentCollection;

/**
 * SQL visitor.
 *
 * @author James G. Willmore
 * @param <T> the SQL identifier collection
 * @param <S> the alias type
 */
public interface SqlVisitor<T, S> {

  /**
   * Visit.
   *
   * @param identifier the identifier
   * @return the string
   */
  String visit(T identifier);

  /**
   * Visit.
   *
   * @param collection the identifier collection
   * @return the string
   */
  String visit(SqlFragmentCollection<T> collection);
}
