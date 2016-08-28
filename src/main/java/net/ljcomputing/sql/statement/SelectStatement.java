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

import java.util.HashSet;
import java.util.Set;

import net.ljcomputing.sql.clause.Predicate;
import net.ljcomputing.sql.clause.Select;
import net.ljcomputing.sql.clause.Where;
import net.ljcomputing.sql.identifier.Column;

/**
 * SQL SELECT statement implementation.
 * 
 * @author James G. Willmore
 *
 */
public class SelectStatement implements Statement {
  
  /** The select clause. */
  private final transient Select select;
  
  /** The predicates clauses. */
  private final transient Set<Predicate> predicates = new HashSet<Predicate>();
  
  /**
   * Instantiates a new select statement.
   *
   * @param columns the columns
   */
  public SelectStatement(final Column ... columns) {
    select = new Select(columns);
  }
  
  /**
   * Adds a predicate. 
   * NOTE: the conjunction is IGNORED for the LAST predicate added.
   *
   * @param predicate the predicate
   */
  public void addPredicate(final Predicate predicate) {
    predicates.add(predicate);
  }
  
  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    final StringBuffer buf = new StringBuffer(select.toString());
    
    if (!predicates.isEmpty()) {
      final Where where = new Where(predicates.toArray(new Predicate[predicates.size()]));
      buf.append(where.toString());
    }
    
    return buf.toString();
  }
}
