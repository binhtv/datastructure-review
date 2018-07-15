package vn.binhtv.datastructure.stack;

import vn.binhtv.datastructure.list.single.LinkedList;

/**
 * The Stack class represents a last-in-first-out (LIFO) stack of objects. This
 * is implemented using {@link LinkedList} When a stack is first created, it
 * contains no items.
 * 
 * @author binhtran
 *
 */
public class Stack<T> {
	private LinkedList<T> list;
	private int top = 0;

	/**
	 * Creates an empty Stack.
	 */
	public Stack() {
		this.list = new LinkedList<T>();
	}

	/**
	 * Tests if this stack is empty.
	 * 
	 * @return boolean return true on empty otherwise false
	 */
	public boolean isEmpty() {
		return this.top == 0;
	}

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return T
	 */
	public T peek() {
		return this.isEmpty() ? null : this.list.get(this.top - 1);
	}

	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @return T added item
	 */
	public T push(T value) {
		this.list.append(value);
		this.top++;
		return value;
	}

	/**
	 * Removes the object at the top of this stack and returns that object as
	 * the value of this function.
	 * 
	 * @return T removed item
	 */
	public T pop() {
		T value = null;
		if (!this.isEmpty()) {
			value = this.list.removeAt(this.top - 1);
			this.top--;
		}

		return value;
	}

	/**
	 * Returns the 1-based position where an object is on this stack.
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
