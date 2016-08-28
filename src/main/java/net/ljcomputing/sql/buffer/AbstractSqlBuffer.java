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

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Abstract implementation of a SQL buffer.
 * 
 * @author James G. Willmore
 *
 */
@SuppressWarnings({ "PMD.AbstractClassWithoutAbstractMethod" })
public abstract class AbstractSqlBuffer<T> implements SqlBuffer<T> {

  /** The elements of the buffer. */
  private transient T[] elements;

  /** The capacity. */
  private transient int capacity;

  /** The current position of the buffer. */
  private transient int position;

  /**
   * Instantiates a new abstract sql buffer.
   *
   * @param elements the elements
   */
  public AbstractSqlBuffer(@SuppressWarnings("unchecked") final T... elements) {
    this.elements = elements;
    capacity = this.elements.length;
    position = 0;
  }

  /**
   * Returns true if the iteration has more elements.
   *
   * @return true, if successful
   */
  public boolean hasNext() {
    return position < capacity;
  }

  /**
   * @see java.util.Iterator#next()
   */
  public final T next() {
    if (position >= capacity) {
      throw new NoSuchElementException();
    }

    return elements[position++];
  }

  /**
   * @see java.lang.Iterable#iterator()
   */
  public final Iterator<T> iterator() {
    position = 0;
    return (Iterator<T>) this;
  }

  /**
   * @see net.ljcomputing.sql.buffer.SqlBuffer#size()
   */
  @Override
  public final int size() {
    return capacity;
  }

  /**
   * @see net.ljcomputing.sql.buffer.SqlBuffer#isEmpty()
   */
  @Override
  public final boolean isEmpty() {
    return capacity == 0;
  }

  /**
   * @see net.ljcomputing.sql.buffer.SqlBuffer#contains(java.lang.Object)
   */
  @Override
  // modified to avoid PMD UR-Anomaly
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
   * @see net.ljcomputing.sql.buffer.SqlBuffer#add(java.lang.Object)
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
   * @see net.ljcomputing.sql.buffer.SqlBuffer#remove(java.lang.Object)
   */
  @SuppressWarnings("unchecked")
  @Override
  public final boolean remove(final T obj) {
    final Object[] newElements = new Object[capacity - 1];

    for (int i = 0; i < elements.length; i++) {
      final T current = elements[i];

      if (!current.equals(obj)) {
        newElements[i] = current;
      }
    }

    return resize((T[]) newElements);
  }

  /**
   * @see net.ljcomputing.sql.buffer.SqlBuffer#addAll(java.util.Collection)
   */
  @Override
  public final boolean addAll(final Collection<? extends T> collection) {
    @SuppressWarnings("unchecked")
    final T[] newElements = (T[]) collection.toArray(new Object[collection.size()]);
    return resize(newElements);
  }

  /**
   * Resize the elements array.
   *
   * @param newElements the new elements
   * @return true, if successful
   */
  private final boolean resize(@SuppressWarnings("unchecked") final T... newElements) {
    final int newCapacity = newElements.length + capacity;

    System.arraycopy(elements, 0, newElements, 0, newCapacity);

    elements = newElements;
    capacity = elements.length;
    position = 0;

    return true;
  }

  /**
   * @see net.ljcomputing.sql.buffer.SqlBuffer#clear()
   */
  @SuppressWarnings("unchecked")
  @Override
  public void clear() {
    capacity = 0;
    position = 0;
    elements = (T[]) new Object[0];
  }
}
