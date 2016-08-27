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

package net.ljcomputing.sql.value;

/**
 * Interface shared by all SQL values.
 *
 * @author James G. Willmore
 * @param <T> the type of value
 */
public interface Value<T> {
  
  /**
   * The value provided by the implementation class.
   *
   * @return the t
   */
  T value();
}
