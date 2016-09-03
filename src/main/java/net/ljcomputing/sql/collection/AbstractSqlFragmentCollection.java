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

import java.util.Arrays;
import java.util.Collection;

/**
 * Abstract implementation of a collection of SQL fragments.
 * 
 * @author James G. Willmore
 *
 */
@SuppressWarnings({ "PMD.AbstractClassWithoutAbstractMethod" })
public abstract class AbstractSqlFragmentCollection<T> extends AbstractSqlFragmentIterator<T>
    implements SqlFragmentCollection<T> {

  /**
   * Instantiates a new abstract sql buffer.
   *
   * @param elements the elements
   */
  @SuppressWarnings("PMD.AvoidDuplicateLiterals")
  public AbstractSqlFragmentCollection(@SuppressWarnings("unchecked") final T... elements) {
    super(elements);
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlFragmentCollection#size()
   */
  @Override
  public final int size() {
    return capacity;
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlFragmentCollection#isEmpty()
   */
  @Override
  public final boolean isEmpty() {
    return capacity == 0;
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlFragmentCollection
   * #contains(java.lang.Object)
   */
  @SuppressWarnings({ "PMD.DataflowAnomalyAnalysis", "PMD.LawOfDemeter" })
  @Override
  public final boolean contains(final T obj) {
    boolean result = false;

    if (obj != null) {
      for (int i = 0; i < elements.length; i++) {
        final T element = elements[i];

        if (element.equals(obj)) {
          result = true;
          break;
        }
      }
    }

    return result;
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlFragmentCollection#add(java.lang.Object)
   */
  @Override
  public final boolean add(final T element) {
    final int newCapacity = capacity + 1;
    elements = Arrays.copyOf(elements, newCapacity);
    elements[capacity] = element;
    capacity = elements.length;
    position = 0;

    return true;
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlFragmentCollection
   * #addAll(java.util.Collection)
   */
  @Override
  public final boolean addAll(final Collection<? extends T> collection) {
    @SuppressWarnings("unchecked")
    final T[] newElements = (T[]) collection.toArray(new Object[collection.size()]);
    return super.resize(newElements);
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlFragmentCollection#clear()
   */
  @SuppressWarnings("unchecked")
  @Override
  public void clear() {
    capacity = 0;
    position = 0;
    elements = (T[]) new Object[0];
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "AbstractSqlFragmentCollection [elements=" + Arrays.toString(elements) + ", capacity="
        + capacity + ", position=" + position + "]";
  }
}
