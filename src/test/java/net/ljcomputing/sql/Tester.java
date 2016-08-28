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

import java.util.Iterator;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import net.ljcomputing.sql.buffer.ColumnBuffer;
import net.ljcomputing.sql.clause.Delete;
import net.ljcomputing.sql.clause.EqualsPredicate;
import net.ljcomputing.sql.clause.Predicate;
import net.ljcomputing.sql.clause.Select;
import net.ljcomputing.sql.clause.Update;
import net.ljcomputing.sql.clause.Where;
import net.ljcomputing.sql.identifier.Column;
import net.ljcomputing.sql.identifier.Table;
import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Conjunction;
import net.ljcomputing.sql.literal.Literal;
import net.ljcomputing.sql.literal.Operand;
import net.ljcomputing.sql.statement.SelectStatement;

/**
 * @author James G. Willmore
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tester {

  @Test
  @Ignore
  public void test1() {
    for (final Keywords token : Keywords.values()) {
      System.out.println(token);
    }
  }

  @Test
  @Ignore
  public void test2() {
    for (final Literal token : Literal.values()) {
      System.out.println(token);
    }
  }

  @Test
  @Ignore
  public void test3() {
    for (final Operand token : Operand.values()) {
      System.out.println(token);
    }
  }
  
  @Test
  public void test4() {
    final Table table1 = new Table("foo", "fo");
    final Column col1 = new Column(table1, "bar", "br");

    final Table table2 = new Table("xray", "xa");
    final Column col2 = new Column(table2, "baz", "bz");
    
    final Select select = new Select(col1, col2);
    System.out.println(select);

    final Delete delete = new Delete(table1);
    System.out.println(delete);

    final Update update = new Update(table2);
    System.out.println(update);

    final Predicate predicate1 = new EqualsPredicate(col1, Literal.Question);//, Conjunction.Or);
    System.out.println(predicate1);

    final Predicate predicate2 = new EqualsPredicate(col2, Literal.Question);
    System.out.println(predicate2);

    final Where where = new Where(predicate1, predicate2);
    System.out.println(where);
  }

  @Test
  public void test5() {
    final Table table1 = new Table("foo", "fo");
    final Column col1 = new Column(table1, "bar", "br");

    final Table table2 = new Table("xray", "xa");
    final Column col2 = new Column(table2, "baz", "bz");

    final Predicate predicate1 = new EqualsPredicate(col1, Literal.Question, Conjunction.Or);

    final SelectStatement nestedSelect = new SelectStatement(col2);
    final StringBuffer nestedBuf = new StringBuffer(Literal.LeftParen.toString())
        .append(nestedSelect).append(Literal.RightParen.toString());
    
    final Predicate predicate2 = new EqualsPredicate(col2, nestedBuf.toString());
//    final Predicate predicate2 = new EqualsPredicate(col2, Literal.Question);

    final SelectStatement selectStatement = new SelectStatement(col1, col2);
    selectStatement.addPredicate(predicate1);
    selectStatement.addPredicate(predicate2);
    System.out.println(selectStatement);
  }

  @Test
  public void test6() {
    final Table table1 = new Table("foo");//, "fo");
    final Column col1 = new Column(table1, "bar", "br");

    final Table table2 = new Table("xray", "xa");
    final Column col2 = new Column(table2, "baz", "bz");
    
    final ColumnBuffer columnBuffer = new ColumnBuffer(col1);
    columnBuffer.add(col2);
    
    for(final Column column : columnBuffer) {
      System.out.println("column: ");
      System.out.println("  as     : " + column.as());
      System.out.println("  aliased: " + column.aliased());
    }

//    // clear buffer
//    columnBuffer.clear();
    
    Iterator<Column> columnIterator = columnBuffer.iterator();

    while(columnIterator.hasNext()) {
      final Column column = columnIterator.next();
      System.out.println("column: ");
      System.out.println("  as     : " + column.as());
      System.out.println("  aliased: " + column.aliased());
    }
//    will throw a NoSuchElementException
//    System.out.println(columnIterator.next());
  }
}
