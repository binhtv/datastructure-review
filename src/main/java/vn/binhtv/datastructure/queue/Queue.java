package vn.binhtv.datastructure.queue;

import vn.binhtv.datastructure.list.single.LinkedList;

/**
 * The Queue class represents a first-in-first-out (FIFO) queue of objects. This
 * is implemented using {@link LinkedList} When a queue is first created, it
 * contains no items.
 * 
 * @author binhtran
 *
 */
public class Queue<T> {
	private LinkedList<T> list;

	/**
	 * Creates an empty Queue.
	 */
	public Queue() {
		this.list = new LinkedList<T>();
	}

	/**
	 * Tests if this queue is empty.
	 * 
	 * @return boolean return true on empty otherwise false
	 */
	public boolean isEmpty() {
		return this.list.count() == 0;
	}

	/**
	 * Looks at the object at the top of this queue without removing it from the
	 * queue.
	 * 
	 * @return T
	 */
	public T peek() {
		return this.isEmpty() ? null : this.list.get(0);
	}

	/**
	 * Pushes an item onto the top of this queue.
	 * 
	 * @return T added item
	 */
	public T enqueue(T value) {
		this.list.append(value);
		return value;
	}

	/**
	 * Removes the object at the top of this queue and returns that object as
	 * the value of this function.
	 * 
	 * @return T removed item
	 */
	public T dequeue() {
		T value = null;
		if (!this.isEmpty()) {
			value = this.list.removeAt(0);
		}

		return value;
	}

	/**
	 * Returns the 1-based position where an object is on this queue.
	 * 
	 * @param value
	 *            the searching value
	 * @return integer
	 */
	public int search(T value) {
		int index = this.list.search(value);
		return index < 0 ? index : index + 1;
	}
}
