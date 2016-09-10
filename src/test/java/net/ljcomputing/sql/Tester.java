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

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.ljcomputing.sql.clause.DeleteClause;
import net.ljcomputing.sql.clause.UpdateClause;
import net.ljcomputing.sql.collection.ColumnCollection;
import net.ljcomputing.sql.collection.SchemaCollection;
import net.ljcomputing.sql.collection.TableCollection;
import net.ljcomputing.sql.expression.EqualsExpression;
import net.ljcomputing.sql.identifier.column.ColumnIdentifier;
import net.ljcomputing.sql.identifier.schema.SchemaIdentifier;
import net.ljcomputing.sql.identifier.table.TableIdentifier;
import net.ljcomputing.sql.strategy.FunctionStrategy;

/**
 * JUnit tests.
 * 
 * @author James G. Willmore
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tester {

  /** The SLF4J Logger. */
  private final static Logger LOGGER = LoggerFactory.getLogger(Tester.class);
  
  private static void log(final String testId, final boolean start) {
    final String value = start ? "== STARTED {} ==" : "== ENDDED  {} ==";
    LOGGER.info(value, testId);
  }

  /**
   * Test 01 - SQL list.
   */
  @Test
  public void test0100List() {
    final String testName = "test0100List";
    log(testName, true);

    final ColumnIdentifier col1 = new ColumnIdentifier("COLUMN_1");
    final ColumnIdentifier col11 = new ColumnIdentifier("COLUMN_11", "C1");
    col11.setFunction(FunctionStrategy.Max);
    final ColumnIdentifier col12 = new ColumnIdentifier("COLUMN_12", "C2");
    
    final ColumnCollection columnCollections1 = new ColumnCollection(col1, col11, col12);

    final ColumnIdentifier col2 = new ColumnIdentifier("COLUMN_2");
    final ColumnIdentifier col21 = new ColumnIdentifier("COLUMN_21", "C2");
    
    final ColumnCollection columnCollections2 = new ColumnCollection(col2, col21);
    
    final TableIdentifier table1 = new TableIdentifier("TABLE_1", "T1", columnCollections1);
    final TableIdentifier table11 = new TableIdentifier("TABLE_21", "T21", columnCollections2);
    
    final TableCollection tableCollections1 = new TableCollection(table1);
    final TableCollection tableCollections11 = new TableCollection(table11);
    
    final SchemaIdentifier schema1 = new SchemaIdentifier("SCHEMA1", tableCollections1);
    final SchemaIdentifier schema2 = new SchemaIdentifier("SCHEMA2", tableCollections11);
    
    final SchemaCollection schemaCollections1 = new SchemaCollection(schema1, schema2);

    LOGGER.debug("sql-1: {}", schemaCollections1.toSqlList());
    LOGGER.debug("sql-2: {}", tableCollections1.toSqlList());
    LOGGER.debug("sql-3: {}", columnCollections1.toSqlList());
    
    log(testName, false);
  }

  /**
   * Test 02 - SQL list.
   */
  @Test
  public void test0200Clause() {
    final String testName = "test0200Clause";
    log(testName, true);

    final ColumnIdentifier col1 = new ColumnIdentifier("COLUMN_1");
    final ColumnIdentifier col11 = new ColumnIdentifier("COLUMN_11", "C1");
    col11.setFunction(FunctionStrategy.Max);
    final ColumnIdentifier col12 = new ColumnIdentifier("COLUMN_12", "C2");
    
    final ColumnCollection columnCollections1 = new ColumnCollection(col1, col11, col12);
    
    final TableIdentifier table1 = new TableIdentifier("TABLE_1", "T1", columnCollections1);
    
    final TableCollection tableCollections1 = new TableCollection(table1);
    
    final SchemaIdentifier schema1 = new SchemaIdentifier("SCHEMA1", tableCollections1);
    
    final DeleteClause deleteClause1 = new DeleteClause(schema1);
    final DeleteClause deleteClause2 = new DeleteClause(table1);
    
    final UpdateClause updateClause1 = new UpdateClause(schema1);
    final UpdateClause updateClause2 = new UpdateClause(table1);

    LOGGER.debug("sql-1: {}", deleteClause1.toSql());
    LOGGER.debug("sql-2: {}", deleteClause2.toSql());
    LOGGER.debug("sql-3: {}", updateClause1.toSql());
    LOGGER.debug("sql-4: {}", updateClause2.toSql());
    
    log(testName, false);
  }

  /**
   * Test 03 - SQL expression.
   */
  @Test
  public void test0300Expression() {
    final String testName = "test0300Expression";
    log(testName, true);

    final ColumnIdentifier col1 = new ColumnIdentifier("COLUMN_1");
    final ColumnIdentifier col11 = new ColumnIdentifier("COLUMN_11", "C1");
    col11.setFunction(FunctionStrategy.Max);
    final ColumnIdentifier col12 = new ColumnIdentifier("COLUMN_12", "C2");
    
    final ColumnCollection columnCollections1 = new ColumnCollection(col1, col11, col12);
    
    final TableIdentifier table1 = new TableIdentifier("TABLE_1", "T1", columnCollections1);
    
    final TableCollection tableCollections1 = new TableCollection(table1);
    
    final SchemaIdentifier schema1 = new SchemaIdentifier("SCHEMA1", tableCollections1);
    
    final Object[] values1 = new Object[]{null, 'a'};
    
    final EqualsExpression equalsExpression1 = new EqualsExpression(col1, values1);

    LOGGER.debug("sql-1: {}", equalsExpression1.toSql());
    
    log(testName, false);
  }
}
