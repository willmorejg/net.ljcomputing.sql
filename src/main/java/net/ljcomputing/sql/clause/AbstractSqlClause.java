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

import java.util.Iterator;

import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.identifier.schema.SchemaIdentifier;
import net.ljcomputing.sql.identifier.table.TableIdentifier;
import net.ljcomputing.sql.literal.Literal;

/**
 * Abstract implementation of a SQL clause.
 * 
 * @author James G. Willmore
 *
 */
public abstract class AbstractSqlClause implements Clause {
  
  /** The statement. */
  private final String statement;
  
  /** The identifier. */
  protected final Identifier identifier;

  /**
   * Instantiates a new abstract sql clause.
   *
   * @param statement the statement
   * @param identifier the identifier
   */
  public AbstractSqlClause(final String statement, final Identifier identifier) {
    this.statement = statement;
    this.identifier = identifier;
  }

  /**
   * @see net.ljcomputing.sql.clause.Clause#toSql()
   */
  @Override
  public String toSql() {
    final StringBuilder buf = new StringBuilder();
    final String from = from();
    return buf.append(statement).append(from).toString();
  }
  
  /**
   * From portion of SQL clause.
   *
   * @return the string
   */
  private String from() {
    final StringBuilder buf = new StringBuilder();
    
    if (identifier instanceof SchemaIdentifier) {
      buf.append(identifier.getName());
      
      final Iterator<TableIdentifier> tableIt = ((SchemaIdentifier) identifier).tables().iterator();
      final TableIdentifier tableId = tableIt.next();
      
      buf.append(Literal.Period).append(tableId.getName());
      
    } else if (identifier instanceof TableIdentifier) {
      buf.append(identifier.getName());
    }
    
    return buf.toString();
  }
}
