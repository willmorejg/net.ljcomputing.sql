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

import net.ljcomputing.sql.collection.ColumnCollection;
import net.ljcomputing.sql.identifier.column.ColumnIdentifier;
import net.ljcomputing.sql.identifier.schema.SchemaIdentifier;
import net.ljcomputing.sql.identifier.table.TableIdentifier;

/**
 * Defined the dotted identifier visitors.
 * 
 * @author James G. Willmore
 *
 */
public interface DottedVisitor {

  /**
   * To SQL list fragment.
   *
   * @param identifier the identifier
   * @return the string
   */
  String toSqlFragment(SchemaIdentifier identifier);

  /**
   * To SQL list fragment.
   *
   * @param identifier the identifier
   * @return the string
   */
  String toSqlFragment(TableIdentifier identifier);

  /**
   * To SQL list fragment.
   *
   * @param identifier the identifier
   * @return the string
   */
  String toSqlFragment(ColumnIdentifier identifier);
  
  /**
   * To SQL list fragment.
   *
   * @param identifiers the identifiers
   * @return the string
   */
  String toSqlFragment(ColumnCollection identifiers);
}
