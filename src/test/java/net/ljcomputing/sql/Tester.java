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

import net.ljcomputing.sql.clause.SelectClause;
import net.ljcomputing.sql.identifier.Column;
import net.ljcomputing.sql.identifier.Table;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;

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
    
    final Table table1 = new Table("foo", "fo");
    final Column col1 = new Column(table1, "bar", "br");

    final Table table2 = new Table("xray", "xa");
    final Column col2 = new Column(table2, "baz", "bz");    
    final SelectClause selectClause = new SelectClause(col1, col2);
    
    System.out.println(selectClause.toClause());
  }

}
