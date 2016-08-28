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

import net.ljcomputing.sql.buffer.PredicateBuffer;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Conjunction;
import net.ljcomputing.sql.literal.Literal;

/**
 * SQL WHERE clause.
 * 
 * @author James G. Willmore
 *
 */
public class Where extends AbstractClause implements Clause {

  /** The predicates. */
  private final transient PredicateBuffer predicates;

  /**
   * Instantiates a new where clause.
   *
   * @param predicates the predicates
   */
  public Where(final Predicate... predicates) {
    super();
    this.predicates = new PredicateBuffer(predicates);
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    final StringBuffer buf = new StringBuffer();

    if (!predicates.isEmpty()) {
      buf.append(Keywords.Where.toString()).append(Literal.Space);

      final Iterator<Predicate> predicatesIt = predicates.iterator();

      while (predicatesIt.hasNext()) {
        final Predicate predicate = predicatesIt.next();

        addPredicate(buf, predicate);

        //do we have any more predicates?
        if (predicatesIt.hasNext()) {
          //the predicate counter is incremented, 
          //but we are still looking at the most current predicate in the loop
          addConjunction(buf, predicate);
        }
      }
    }

    return buf.toString();
  }

  /**
   * Adds the conjunction.
   *
   * @param buf the buf
   * @param predicate the predicate
   */
  private static final void addConjunction(final StringBuffer buf, final Predicate predicate) {
    if (predicate.hasConjunction()) {
      final Conjunction conjunction = predicate.getConjunction();
      buf.append(Literal.Space).append(conjunction.toString());
    } else {
      buf.append(Literal.Space).append(Conjunction.And);
    }
    
    buf.append(Literal.Space);
  }
}
