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

package net.ljcomputing.sql.strategy;

import net.ljcomputing.sql.keyword.Keywords;
import net.ljcomputing.sql.literal.Literal;

/**
 * Enumeration of SQL functions.
 * 
 * @author James G. Willmore
 *
 */
public enum FunctionStrategy implements Function {
  Distinct {
    /**
     * @see net.ljcomputing.sql.strategy.Function#toSql(java.lang.String)
     */
    @Override
    public String toSql(final String idValue) {
      return new StringBuilder(Keywords.Distinct.toString())
          .append(Literal.Space).append(idValue)
          .toString();
    }
  },
  Avg {
    /**
     * @see net.ljcomputing.sql.strategy.Function#toSql(java.lang.String)
     */
    @Override
    public String toSql(final String idValue) {
      return new StringBuilder(Keywords.Avg.toString()).append(Literal.LeftParen)
          .append(idValue).append(Literal.RightParen)
          .toString();
    }
  },
  Count {
    /**
     * @see net.ljcomputing.sql.strategy.Function#toSql(java.lang.String)
     */
    @Override
    public String toSql(final String idValue) {
      return new StringBuilder(Keywords.Count.toString())
          .append(Literal.LeftParen).append(idValue).append(Literal.RightParen)
          .toString();
    }
  },
  Min {
    /**
     * @see net.ljcomputing.sql.strategy.Function#toSql(java.lang.String)
     */
    @Override
    public String toSql(final String idValue) {
      return new StringBuilder(Keywords.Min.toString()).append(Literal.LeftParen)
          .append(idValue).append(Literal.RightParen)
          .toString();
    }
  },
  Max {
    /**
     * @see net.ljcomputing.sql.strategy.Function#toSql(java.lang.String)
     */
    @Override
    public String toSql(final String idValue) {
      return new StringBuilder(Keywords.Max.toString()).append(Literal.LeftParen)
          .append(idValue).append(Literal.RightParen)
          .toString();
    }
  },
  Sum {
    /**
     * @see net.ljcomputing.sql.strategy.Function#toSql(java.lang.String)
     */
    @Override
    public String toSql(final String idValue) {
      return new StringBuilder(Keywords.Sum.toString()).append(Literal.LeftParen)
          .append(idValue).append(Literal.RightParen)
          .toString();
    }
  },
  Upper {
    /**
     * @see net.ljcomputing.sql.strategy.Function#toSql(java.lang.String)
     */
    @Override
    public String toSql(final String idValue) {
      return new StringBuilder(Keywords.Upper.toString())
          .append(Literal.LeftParen).append(idValue).append(Literal.RightParen)
          .toString();
    }
  },
  Lower {
    /**
     * @see net.ljcomputing.sql.strategy.Function#toSql(java.lang.String)
     */
    @Override
    public String toSql(final String idValue) {
      return new StringBuilder(Keywords.Lower.toString())
          .append(Literal.LeftParen).append(idValue).append(Literal.RightParen)
          .toString();
    }
  };
}
