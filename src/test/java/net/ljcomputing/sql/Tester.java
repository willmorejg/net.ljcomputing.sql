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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
  
  /** The SLF4J Logger. */
  private final static Logger LOGGER = LoggerFactory.getLogger(Tester.class);

  @Test
  public void test1() {
    for (final Keywords token : Keywords.values()) {
      LOGGER.debug("token: {} ", token);
    }
  }

  @Test
  public void test2() {
    for (final Literal token : Literal.values()) {
      LOGGER.debug("token: {} ", token);
    }
  }

  @Test
  public void test3() {
    for (final Operand token : Operand.values()) {
      LOGGER.debug("token: {} ", token);
    }
  }
  
  @Test
  public void test4() {
    final Table table1 = new Table("alice", "a");
    final Column col1 = new Column(table1, "alpha", "alp");

    final Table table2 = new Table("bob", "b");
    final Column col2 = new Column(table2, "bravo", "bra");
    
    final Select select = new Select(col1, col2);
    LOGGER.debug("select: {}", select);

    final Delete delete = new Delete(table1);
    LOGGER.debug("delete: {}", delete);

    final Update update = new Update(table2);
    LOGGER.debug("update: {}", update);

    final Predicate predicate1 = new EqualsPredicate(col1, Literal.Question, Conjunction.Or);
    final Predicate predicate2 = new EqualsPredicate(col2, Literal.Question);

    final Where where = new Where(predicate1, predicate2);
    LOGGER.debug("where: {}", where);
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
    LOGGER.debug("selectStatement: {}", selectStatement);
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
      LOGGER.debug("column: ");
      LOGGER.debug("  as      : {}", column.as());
      LOGGER.debug("  aliased : {}", column.aliased());
    }

//    // clear buffer
//    columnBuffer.clear();
    
    Iterator<Column> columnIterator = columnBuffer.iterator();

    while(columnIterator.hasNext()) {
      final Column column = columnIterator.next();
      LOGGER.debug("column: ");
      LOGGER.debug("  as      : {}", column.as());
      LOGGER.debug("  aliased : {}", column.aliased());
    }
//    will throw a NoSuchElementException
//    LOGGER.debug("column: {}", columnIterator.next());
  }
}
