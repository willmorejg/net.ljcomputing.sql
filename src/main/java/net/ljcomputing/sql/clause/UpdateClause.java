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

package net.ljcomputing.sql.clause;

import net.ljcomputing.sql.identifier.schema.SchemaIdentifier;
import net.ljcomputing.sql.identifier.table.TableIdentifier;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;

/**
 * UPDATE SQL clause.
 * 
 * @author James G. Willmore
 *
 */
public class UpdateClause extends AbstractSqlClause {
  
  /** The Constant STATEMENT. */
  private final static String STATEMENT = new StringBuilder().append(Keywords.Update)
      .append(Literal.Space).toString();

  /**
   * Instantiates a new update clause.
   *
   * @param schema the schema
   */
  public UpdateClause(final SchemaIdentifier schema) {
    super(STATEMENT, schema);
  }

  /**
   * Instantiates a new update clause.
   *
   * @param table the table
   */
  public UpdateClause(final TableIdentifier table) {
    super(STATEMENT, table);
  }

}
