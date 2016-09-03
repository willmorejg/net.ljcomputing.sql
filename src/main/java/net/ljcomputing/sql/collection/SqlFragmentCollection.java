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

package net.ljcomputing.sql.collection;

import java.util.Collection;
import java.util.Iterator;

/**
 * Interface shared by all collections of SQL fragments.
 * 
 * @author James G. Willmore
 *
 */
public interface SqlFragmentCollection<T> extends Iterator<T>, Iterable<T> {

  /**
   * Returns the number of elements in implementing class.
   *
   * @return the int
   */
  int size();

  /**
   * Returns true if implemented class contains no elements.
   *
   * @return true, if is empty
   */
  boolean isEmpty();

  /**
   * Returns true if the implemented class contains the specified element.
   *
   * @param obj the obj
   * @return true, if successful
   */
  boolean contains(T obj);

  /**
   * Add the given element to the implementing class.
   *
   * @param element the element
   * @return true, if successful
   */
  boolean add(T element);

  /**
   * Adds all of the elements in the specified collection to 
   * this collection.
   *
   * @param collection the collection
   * @return true, if successful
   */
  boolean addAll(Collection<? extends T> collection);

  /**
   * Removes all of the elements from this collection. 
   * The collection will be empty after this method returns.
   */
  void clear();
}
