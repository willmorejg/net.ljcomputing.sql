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

package net.ljcomputing.sql.keyword;

/**
 * Enumeration of SQL keywords.
 * 
 * @author James G. Willmore
 *
 */
public enum Keywords {
  Absolute("ABSOLUTE"),
  Action("ACTION"),
  Add("ADD"),
  All("ALL"),
  Allocate("ALLOCATE"),
  Alter("ALTER"),
  And("AND"),
  Any("ANY"),
  Are("ARE"),
  As("AS"),
  Asc("ASC"),
  Assertion("ASSERTION"),
  At("AT"),
  Authorization("AUTHORIZATION"),
  Avg("AVG"),
  Begin("BEGIN"),
  Between("BETWEEN"),
  Bit("BIT"),
  BitLength("BIT_LENGTH"),
  Both("BOTH"),
  By("BY"),
  Cascade("CASCADE"),
  Cascaded("CASCADED"),
  Case("CASE"),
  Cast("CAST"),
  Catalog("CATALOG"),
  Char("CHAR"),
  Character("CHARACTER"),
  CharLength("CHAR_LENGTH"),
  CharacterLength("CHARACTER_LENGTH"),
  Check("CHECK"),
  Close("CLOSE"),
  Coalesce("COALESCE"),
  Collate("COLLATE"),
  Collation("COLLATION"),
  Column("COLUMN"),
  Commit("COMMIT"),
  Connect("CONNECT"),
  Connection("CONNECTION"),
  Constraint("CONSTRAINT"),
  Constraints("CONSTRAINTS"),
  Continue("CONTINUE"),
  Convert("CONVERT"),
  Corresponding("CORRESPONDING"),
  Count("COUNT"),
  Create("CREATE"),
  Cross("CROSS"),
  Current("CURRENT"),
  CurrentDate("CURRENT_DATE"),
  CurrentTime("CURRENT_TIME"),
  CurrentTimestamp("CURRENT_TIMESTAMP"),
  CurrentUser("CURRENT_USER"),
  Cursor("CURSOR"),
  Date("DATE"),
  Day("DAY"),
  Deallocate("DEALLOCATE"),
  Dec("DEC"),
  Decimal("DECIMAL"),
  Declare("DECLARE"),
  Default("DEFAULT"),
  Deferrable("DEFERRABLE"),
  Deferred("DEFERRED"),
  Delete("DELETE"),
  Desc("DESC"),
  Describe("DESCRIBE"),
  Descriptor("DESCRIPTOR"),
  Diagnostics("DIAGNOSTICS"),
  Disconnect("DISCONNECT"),
  Distinct("DISTINCT"),
  Domain("DOMAIN"),
  Double("DOUBLE"),
  Drop("DROP"),
  Else("ELSE"),
  End("END"),
  EndExec("END-EXEC"),
  Escape("ESCAPE"),
  Except("EXCEPT"),
  Exception("EXCEPTION"),
  Exec("EXEC"),
  Execute("EXECUTE"),
  Exists("EXISTS"),
  External("EXTERNAL"),
  Extract("EXTRACT"),
  False("FALSE"),
  Fetch("FETCH"),
  First("FIRST"),
  Float("FLOAT"),
  For("FOR"),
  Foreign("FOREIGN"),
  Found("FOUND"),
  From("FROM"),
  Full("FULL"),
  Get("GET"),
  Global("GLOBAL"),
  Go("GO"),
  Goto("GOTO"),
  Grant("GRANT"),
  Group("GROUP"),
  Having("HAVING"),
  Hour("HOUR"),
  Identity("IDENTITY"),
  Immediate("IMMEDIATE"),
  In("IN"),
  Indicator("INDICATOR"),
  Initially("INITIALLY"),
  Inner("INNER"),
  Input("INPUT"),
  Insensitive("INSENSITIVE"),
  Insert("INSERT"),
  Int("INT"),
  Integer("INTEGER"),
  Intersect("INTERSECT"),
  Interval("INTERVAL"),
  Into("INTO"),
  Is("IS"),
  Isolation("ISOLATION"),
  Join("JOIN"),
  Key("KEY"),
  Language("LANGUAGE"),
  Last("LAST"),
  Leading("LEADING"),
  Left("LEFT"),
  Level("LEVEL"),
  Like("LIKE"),
  Local("LOCAL"),
  Lower("LOWER"),
  Match("MATCH"),
  Max("MAX"),
  Min("MIN"),
  Minute("MINUTE"),
  Module("MODULE"),
  Month("MONTH"),
  Names("NAMES"),
  National("NATIONAL"),
  Natural("NATURAL"),
  Nchar("NCHAR"),
  Next("NEXT"),
  No("NO"),
  Not("NOT"),
  Null("NULL"),
  Nullif("NULLIF"),
  Numeric("NUMERIC"),
  OctetLength("OCTET_LENGTH"),
  Of("OF"),
  On("ON"),
  Only("ONLY"),
  Open("OPEN"),
  Option("OPTION"),
  Or("OR"),
  Order("ORDER"),
  Outer("OUTER"),
  Output("OUTPUT"),
  Overlaps("OVERLAPS"),
  Pad("PAD"),
  Partial("PARTIAL"),
  Position("POSITION"),
  Precision("PRECISION"),
  Prepare("PREPARE"),
  Preserve("PRESERVE"),
  Primary("PRIMARY"),
  Prior("PRIOR"),
  Privileges("PRIVILEGES"),
  Procedure("PROCEDURE"),
  Public("PUBLIC"),
  Read("READ"),
  Real("REAL"),
  References("REFERENCES"),
  Relative("RELATIVE"),
  Restrict("RESTRICT"),
  Revoke("REVOKE"),
  Right("RIGHT"),
  Rollback("ROLLBACK"),
  Rows("ROWS"),
  Schema("SCHEMA"),
  Scroll("SCROLL"),
  Second("SECOND"),
  Section("SECTION"),
  Select("SELECT"),
  Session("SESSION"),
  SessionUser("SESSION_USER"),
  Set("SET"),
  Size("SIZE"),
  Smallint("SMALLINT"),
  Some("SOME"),
  Space("SPACE"),
  Sql("SQL"),
  Sqlcode("SQLCODE"),
  Sqlerror("SQLERROR"),
  Sqlstate("SQLSTATE"),
  Substring("SUBSTRING"),
  Sum("SUM"),
  SystemUser("SYSTEM_USER"),
  Table("TABLE"),
  Temporary("TEMPORARY"),
  Then("THEN"),
  Time("TIME"),
  Timestamp("TIMESTAMP"),
  TimezoneHour("TIMEZONE_HOUR"),
  TimezoneMinute("TIMEZONE_MINUTE"),
  To("TO"),
  Trailing("TRAILING"),
  Transaction("TRANSACTION"),
  Translate("TRANSLATE"),
  Translation("TRANSLATION"),
  Trim("TRIM"),
  True("TRUE"),
  Union("UNION"),
  Unique("UNIQUE"),
  Unknown("UNKNOWN"),
  Update("UPDATE"),
  Upper("UPPER"),
  Usage("USAGE"),
  User("USER"),
  Using("USING"),
  Value("VALUE"),
  Values("VALUES"),
  Varchar("VARCHAR"),
  Varying("VARYING"),
  View("VIEW"),
  When("WHEN"),
  Whenever("WHENEVER"),
  Where("WHERE"),
  With("WITH"),
  Work("WORK"),
  Write("WRITE"),
  Year("YEAR"),
  Zone("ZONE")
  ;
  
  /** The value. */
  private final String value;
  
  /**
   * Instantiates a new token.
   *
   * @param value the value
   */
  private Keywords(final String value) {
    this.value = value;
  }
  
  /**
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return value;
  }
}
