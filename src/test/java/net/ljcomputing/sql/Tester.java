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
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.ljcomputing.sql.collection.ColumnCollection;
import net.ljcomputing.sql.collection.TableCollection;
import net.ljcomputing.sql.flyweight.AliasedAs;
import net.ljcomputing.sql.flyweight.DottedAlias;
import net.ljcomputing.sql.flyweight.TableFlyweight;
import net.ljcomputing.sql.identifier.column.Column;
import net.ljcomputing.sql.identifier.table.Table;
import net.ljcomputing.sql.visitor.ColumnAliasedAsVisitor;
import net.ljcomputing.sql.visitor.ColumnDottedAliasVisitor;
import net.ljcomputing.sql.visitor.TableAliasedAsVisitor;
import net.ljcomputing.sql.visitor.TableDottedAliasVisitor;

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
   * Test 01 - Equals.
   */
  @Test
  public void test01Equals() {
    log("test01Equals", true);
    
    final Column col1 = new Column("COLUMN_1");
    final Column col11 = new Column("COLUMN_1", "C1");
    
    LOGGER.debug("col1.equals(col1): {}", col1.equals(col1));
    LOGGER.debug("col1.equals(col11): {}", col1.equals(col11));
    
    final ColumnCollection columnCollections1 = new ColumnCollection(col1, col11);
    final ColumnCollection columnCollections11 = new ColumnCollection(col1, col11);
    
    LOGGER.debug("columnCollections1.equals(columnCollections1): {}", columnCollections1.equals(columnCollections1));
    LOGGER.debug("columnCollections1.equals(columnCollections11): {}", columnCollections1.equals(columnCollections11));

    final Table table1 = new Table("TABLE_1", columnCollections1);
    final Table table11 = new Table("TABLE_1", "T1", columnCollections11);
    
    LOGGER.debug("table1.equals(table1): {}", table1.equals(table1));
    LOGGER.debug("table1.equals(table11): {}", table1.equals(table11));

    log("test01Equals", false);
  }
  
  /**
   * Test 02 - Iterator.
   */
  @Test
  public void test02Iterator() {
    log("test02Iterator", true);
    
    final Column col1 = new Column("COLUMN_1");
    final Column col11 = new Column("COLUMN_1", "C1");
    
    final ColumnCollection columnCollections1 = new ColumnCollection(col1, col11);
    
    final Table table1 = new Table("TABLE_1", columnCollections1);
    final Table table11 = new Table("TABLE_11", columnCollections1);
    
    final TableCollection tableCollections1 = new TableCollection(table1, table11);

    Iterator<Table> tableIt = tableCollections1.iterator();
    tableCollections1.reverse();
    
    while(tableIt.hasNext()) {
      LOGGER.debug("table: {}", tableIt.next());
    }

    log("test02Iterator", false);
  }
  
  /**
   * Test 03 - dotted alias.
   */
  @Test
  public void test03DottedAlias() {
    log("test03DottedAlias", true);
    final Column col1 = new Column("COLUMN_1");
    final Column col11 = new Column("COLUMN_1", "C1");
    
    final ColumnCollection columnCollections1 = new ColumnCollection(col1, col11);
    
    final Table table1 = new Table("TABLE_1", "T1", columnCollections1);
    final Table table11 = new Table("TABLE_11", "T11", columnCollections1);
    
    final TableCollection tableCollections1 = new TableCollection(table1, table11);
    
    final DottedAlias<Table> tableDotted = new DottedAlias<Table>();
    final String tableAliases = tableDotted.toSql(tableCollections1);
    
    final AliasedAs<Table> tableAs = new AliasedAs<Table>();
    final String tableAliasesAs = tableAs.toSql(tableCollections1);
    
    final DottedAlias<Column> columnDotted = new DottedAlias<Column>();
    final String columnAliases = columnDotted.toSql(columnCollections1);
    
    final AliasedAs<Column> columnAs = new AliasedAs<Column>();
    final String columnAliasesAs = columnAs.toSql(columnCollections1);
    
    LOGGER.debug("tableAliases: {}", tableAliases);
    LOGGER.debug("tableAs: {}", tableAliasesAs);
    LOGGER.debug("columnAliases: {}", columnAliases);
    LOGGER.debug("columnAs: {}", columnAliasesAs);

    log("test03DottedAlias", false);
  }

  /**
   * Test 04 - table dotted visitor.
   */
  @Test
  public void test04TableDottedVisitor() {
    log("test04TableDottedVisitor", true);

    final Column col1 = new Column("COLUMN_1");
    final Column col11 = new Column("COLUMN_1", "C1");
    
    final ColumnCollection columnCollections1 = new ColumnCollection(col1, col11);
    
    final Table table1 = new Table("TABLE_1", "T1", columnCollections1);
    final Table table11 = new Table("TABLE_11", "T11", columnCollections1);
    
    final TableCollection tableCollections1 = new TableCollection(table1, table11);
    
    final TableDottedAliasVisitor tableDottedVisitor = new TableDottedAliasVisitor();
    final TableAliasedAsVisitor tableAsVisitor = new TableAliasedAsVisitor();
    
    LOGGER.debug("tableDottedAliases: {}", tableDottedVisitor.visit(tableCollections1));
    LOGGER.debug("tableAliasesAs: {}", tableAsVisitor.visit(tableCollections1));

    log("test04TableDottedVisitor", false);
  }

  /**
   * Test 05 - column dotted visitor.
   */
  @Test
  public void test05ColumnDottedVisitor() {
    log("test05ColumnDottedVisitor", true);
    final Column col1 = new Column("COLUMN_1");
    final Column col11 = new Column("COLUMN_1", "C1");
    
    final ColumnCollection columnCollections1 = new ColumnCollection(col1, col11);
    
    final ColumnDottedAliasVisitor columnDottedVisitor = new ColumnDottedAliasVisitor();
    final ColumnAliasedAsVisitor columnAsVisitor = new ColumnAliasedAsVisitor();
    
    LOGGER.debug("ColumnDottedAliases: {}", columnDottedVisitor.visit(columnCollections1));
    LOGGER.debug("ColumnAliasesAs: {}", columnAsVisitor.visit(columnCollections1));

    log("test05ColumnDottedVisitor", false);
  }
  
  @Test
  public void test06TableFlyweight() {
    log("test06TableFlyweight", true);

    final Column col1 = new Column("COLUMN_1");
    final Column col11 = new Column("COLUMN_1", "C1");
    
    final ColumnCollection columnCollections1 = new ColumnCollection(col1, col11);
    
    final Table table1 = new Table("TABLE_1", "T1", columnCollections1);
    final Table table11 = new Table("TABLE_11", "T11", columnCollections1);
    
    final TableCollection tableCollections1 = new TableCollection(table1, table11);
    
    final TableFlyweight tableFly = new TableFlyweight();
    LOGGER.debug("sql: {}", tableFly.toSql(tableCollections1));
    
    log("test06TableFlyweight", false);
  }
}
