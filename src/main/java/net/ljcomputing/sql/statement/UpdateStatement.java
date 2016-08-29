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

package net.ljcomputing.sql.statement;

import java.util.Iterator;

import net.ljcomputing.sql.buffer.PredicateBuffer;
import net.ljcomputing.sql.clause.Predicate;
import net.ljcomputing.sql.clause.Update;
import net.ljcomputing.sql.clause.Where;
import net.ljcomputing.sql.identifier.table.Table;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;

/**
 * SQL UPDATE statement implementation.
 * 
 * @author James G. Willmore
 *
 */
public class UpdateStatement implements Statement {

  /** The update clause. */
  private final transient Update update;
  
  private final transient PredicateBuffer newValues;

  /** The predicates clauses. */
  private transient Where whereClause;

  /**
   * Instantiates a new update statement.
   *
   * @param table the table
   * @param setValues the set values
   */
  public UpdateStatement(final Table table, final Predicate ... setValues) {
    update = new Update(table);
    newValues = new PredicateBuffer(setValues);
  }

  /**
   * Add WHERE clause to SELECT statement.
   *
   * @param whereClause the where clause
   */
  public void where(final Where whereClause) {
    this.whereClause = whereClause;
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    final StringBuffer buf = new StringBuffer(update.toString());
    
    Iterator<Predicate> setValuesIt = newValues.iterator();
    
    if (!newValues.isEmpty()) {
      buf.append(Keywords.Set).append(Literal.Space.toString());
      
      while (setValuesIt.hasNext()) {
        final Predicate predicate = setValuesIt.next();

        buf.append(predicate.toString());

        if (setValuesIt.hasNext()) {
          buf.append(Literal.Comma.toString());
        }

        buf.append(Literal.Space.toString());
      } 
    }
    if (whereClause != null) {
      buf.append(whereClause.toString());
    }

    return buf.toString();
  }
}
