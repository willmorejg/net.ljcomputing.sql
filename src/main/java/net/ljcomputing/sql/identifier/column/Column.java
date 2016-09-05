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

package net.ljcomputing.sql.identifier.column;

import net.ljcomputing.sql.identifier.Identifier;
import net.ljcomputing.sql.strategy.FunctionStrategy;

/**
 * Interface defining a COLUMN identifier.
 * 
 * @author James G. Willmore
 *
 */
public interface Column extends Identifier {

  /**
   * Sets the function.
   *
   * @param function the new function
   */
  void setFunction(FunctionStrategy function);

  /**
   * Checks for function.
   *
   * @return true, if successful
   */
  boolean hasFunction();

  /**
   * Gets the function.
   *
   * @return the function
   */
  FunctionStrategy getFunction();
}
