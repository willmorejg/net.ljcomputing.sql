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

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Interface shared by all collections of SQL fragments.
 * 
 * @author James G. Willmore
 *
 */
public interface SqlFragmentIterator<T> extends Iterator<T>, Iterable<T> {

  /**
   * Reverse the order of the iterator.
   */
  void reverse();

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
   * Remove the given element from the array of elements 
   * within the implementing class.
   *
   * @param obj the obj
   * @return true, if successful
   */
  boolean remove(T obj);

  /**
   * @see java.lang.Iterable#iterator()
   */
  @Override
  Iterator<T> iterator();

  /**
   * @see java.lang.Iterable#forEach(java.util.function.Consumer)
   */
  @Override
  void forEach(Consumer<? super T> action);

  /**
   * @see java.lang.Iterable#spliterator()
   */
  @Override
  Spliterator<T> spliterator();
}
