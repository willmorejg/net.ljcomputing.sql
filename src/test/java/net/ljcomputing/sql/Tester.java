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

package net.ljcomputing.sql;

import org.junit.Test;

import net.ljcomputing.sql.clause.Delete;
import net.ljcomputing.sql.clause.Predicate;
import net.ljcomputing.sql.clause.Select;
import net.ljcomputing.sql.clause.Update;
import net.ljcomputing.sql.clause.Where;
import net.ljcomputing.sql.expression.EqualsExpression;
import net.ljcomputing.sql.expression.Expression;
import net.ljcomputing.sql.identifier.Column;
import net.ljcomputing.sql.identifier.Table;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;
import net.ljcomputing.sql.literal.Operand;

/**
 * @author James G. Willmore
 *
 */
public class Tester {

  @Test
  public void test() {
    for(final Keywords token : Keywords.values()) {
      System.out.println(token);
    }

    for(final Literal token : Literal.values()) {
      System.out.println(token);
    }

    for(final Operand token : Operand.values()) {
      System.out.println(token);
    }
    
    final Table table1 = new Table("foo", "fo");
    final Column col1 = new Column(table1, "bar", "br");

    final Table table2 = new Table("xray", "xa");
    final Column col2 = new Column(table2, "baz", "bz");    
    final Select select = new Select(col1, col2);
    
    System.out.println(select.toClause());
    
    final Delete delete = new Delete(table1);
    System.out.println(delete.toClause());
    
    final Update update = new Update(table2);
    System.out.println(update.toClause());
    
    final Predicate predicate = new Predicate(new EqualsExpression(col1), Literal.Question);
    System.out.println(predicate.toPredicate());
    
    final Where where = new Where(predicate);
    System.out.println(where.toClause());
  }

}
