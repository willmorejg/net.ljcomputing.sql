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
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/**
 * Abstract implementation of a collection of SQL fragments.
 * 
 * @author James G. Willmore
 *
 */
@SuppressWarnings({ "PMD.AbstractClassWithoutAbstractMethod", "PMD.TooManyMethods" })
public abstract class AbstractSqlFragmentIterator<T> implements SqlFragmentIterator<T> {

  /** The elements of the collection. */
  protected transient T[] elements;

  /** The capacity. */
  protected transient int capacity;

  /** The current position of the collection. */
  protected transient int position;

  /** The is reversed. */
  protected transient boolean isReversed;

  /**
   * Instantiates a new abstract sql collection.
   *
   * @param elements the elements
   */
  @SuppressWarnings("PMD.AvoidDuplicateLiterals")
  public AbstractSqlFragmentIterator(@SuppressWarnings("unchecked") final T... elements) {
    this.elements = elements;
    capacity = this.elements.length;
  }

  /**
   * Initializes the position.
   */
  private final void initPosition() {
    position = isReversed ? capacity - 1 : 0;
  }

  /**
   * Reverse the order of the iterator.
   */
  public void reverse() {
    isReversed = isReversed ? false : true;
    initPosition();
  }

  /**
   * Returns true if the iteration has more elements.
   *
   * @return true, if successful
   */
  public boolean hasNext() {
    return position > -1 && position < capacity;
  }

  /**
   * @see java.util.Iterator#next()
   */
  public final T next() {
    if (position == -1 || position == capacity) {
      throw new NoSuchElementException();
    }

    return elements[isReversed ? position-- : position++];
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlFragmentIterator
   *    #remove(java.lang.Object)
   */
  @SuppressWarnings({ "unchecked", "PMD.DataflowAnomalyAnalysis", "PMD.LawOfDemeter" })
  @Override
  public final boolean remove(final T obj) {
    final int newCapacity = capacity - 1;
    final Object[] newElements = new Object[newCapacity];

    for (int i = 0; i < elements.length; i++) {
      final T current = elements[i];

      if (!current.equals(obj)) {
        newElements[i] = current;
      }
    }

    return resize((T[]) newElements);
  }

  /**
   * Resize the elements array.
   *
   * @param newElements the new elements
   * @return true, if successful
   */
  protected final boolean resize(@SuppressWarnings("unchecked") final T... newElements) {
    final int newCapacity = newElements.length + capacity;

    System.arraycopy(elements, 0, newElements, 0, newCapacity);

    elements = newElements;
    capacity = elements.length;
    position = 0;

    return true;
  }

  /**
   * @see java.lang.Iterable#iterator()
   */
  public final Iterator<T> iterator() {
    initPosition();
    return (Iterator<T>) this;
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlFragmentCollection
   * #forEach(java.util.function.Consumer)
   */
  @SuppressWarnings("PMD.DataflowAnomalyAnalysis")
  @Override
  public void forEach(final Consumer<? super T> action) {
    position = 0;
    Objects.requireNonNull(action);
    if (action != null) {
      for (final T t : this) {
        action.accept(t);
      }
    }
  }

  /**
   * @see net.ljcomputing.sql.collection.SqlFragmentCollection#spliterator()
   */
  public Spliterator<T> spliterator() {
    return Spliterators.spliteratorUnknownSize(iterator(), 0);
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(elements);
  }

  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings("PMD.DataflowAnomalyAnalysis")
  @Override
  public boolean equals(final Object obj) {
    boolean result = false;

    if (obj != null && getClass() == obj.getClass()) {
      final AbstractSqlFragmentIterator<?> other = (AbstractSqlFragmentIterator<?>) obj;
      result = Objects.equals(elements, other.elements);
    }

    return result;
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
