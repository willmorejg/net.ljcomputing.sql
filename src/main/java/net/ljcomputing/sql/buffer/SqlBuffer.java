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

package net.ljcomputing.sql.buffer;

import java.util.Collection;
import java.util.Iterator;

/**
 * Interface shared by all SQL buffers.
 * 
 * @author James G. Willmore
 *
 */
public interface SqlBuffer<T> extends Iterator<T>, Iterable<T> {

  /**
   * @see java.util.Iterator#hasNext()
   */
  @Override
  boolean hasNext();

  /**
   * @see java.util.Iterator#next()
   */
  @Override
  T next();

  /**
   * @see java.lang.Iterable#iterator()
   */
  @Override
  Iterator<T> iterator();

  /**
   * Returns the number of elements in implementing class.
   */
  int size();

  /**
   * Returns true if implemented class contains no elements.
   */
  boolean isEmpty();

  /**
   * Returns true if the implemented class contains the specified element.
   */
  boolean contains(T obj);

  /**
   * Add the given element to the implementing class.
   */
  boolean add(T element);

  /**
   * Remove the given element from the array of elements 
   * within the implementing class.
   */
  boolean remove(T obj);

  /**
   * Adds all of the elements in the specified collection to 
   * this collection.
   */
  boolean addAll(Collection<? extends T> collection);

  /**
   * Removes all of the elements from this collection. 
   * The collection will be empty after this method returns.
   */
  void clear();
}
