package vn.binhtv.datastructure.list.single;

/**
 * This class is T type singly Linked List. The class provides some methods to
 * accomplish the tasks as below
 * <p>
 * 1. Append an element into the Linked List
 * <p>
 * 2. Remove the tail element from a Linked List
 * <p>
 * 3. Remove all element in the Linked List that is great than a target value
 * <p>
 * 4. Traverse the list
 * 
 * @author binhtran
 */
public class LinkedList<T> {
	private SingleNode<T> head = null;

	/**
	 * Append new T into the end of the list
	 * 
	 * @param T
	 *            value the value will be appended
	 * @return boolean true on success otherwise false
	 */
	public boolean append(T value) {
		SingleNode<T> newNode = new SingleNode<T>(value);
		if (this.head == null) {
			this.head = newNode;
			return true;
		}

		SingleNode<T> node = this.head;
		while (node.getNext() != null) {
			node = node.getNext();
		}
		node.setNext(newNode);

		return true;
	}

	/**
	 * Insert new T into given index
	 * 
	 * @param T
	 *            the value of item
	 * @param int
	 *            at the index
	 * @return boolean true on success otherwise false
	 * @throws IndexOutOfBoundsException
	 */
	public boolean append(T value, int index) {
		if (index < 0 || index > this.count()) {
			throw new IndexOutOfBoundsException("The index is out of bound.");
		}
		SingleNode<T> newNode = new SingleNode<T>(value);
		int cIndex = 0;
		SingleNode<T> node = this.head;
		SingleNode<T> prevNode = null;
		while (cIndex != index) {
			prevNode = node;
			node = node.getNext();
			cIndex++;
		}

		if (node == this.head) {
			newNode.setNext(node);
			this.head = newNode;
		} else {
			newNode.setNext(node);
			prevNode.setNext(newNode);
		}

		return true;
	}

	/**
	 * Remove an item from the end of the list
	 * 
	 * @return T removed value
	 */
	public T remove() {
		SingleNode<T> node = this.head;
		if (node == null) {
			return null;
		}
		SingleNode<T> next = node.getNext();
		while (next.getNext() != null) {
			if (next.getNext().getNext() == null) {
				node = next;
			}
			next = next.getNext();
		}
		next = null;
		node.setNext(null);

		return node.getValue();
	}

	/**
	 * Remove an item from the list at a given index
	 * 
	 * @param integer
	 *            index
	 * @return T removed value
	 * @throws IndexOutOfBoundsException
	 */
	public T removeAt(int index) {
		if (index < 0 || index >= this.count()) {
			throw new IndexOutOfBoundsException("Index is out of bound.");
		}

		SingleNode<T> node = this.head;
		if (node == null) {
			return null;
		}

		int i = 0;
		SingleNode<T> prevNode = null;
		while (i != index) {
			prevNode = node;
			node = node.getNext();
			i++;
		}
		
		SingleNode<T> nextNode = node.getNext();
		if (prevNode != null && nextNode != null) {
			prevNode.setNext(nextNode);
			node.setNext(null);
		} else if (prevNode == null && nextNode != null) {
			this.head = nextNode;
			node.setNext(null);
		} else if (prevNode != null && nextNode == null) {
			prevNode.setNext(null);
		} else {
			this.head = null;
		}

		return node.getValue();
	}

	/**
	 * Remove all nodes from the list
	 * 
	 * @return boolean true on success otherwise false
	 */
	public boolean removeAll() {
		while (this.head != null) {
			this.head = this.head.getNext();
		}

		return true;
	}

	/**
	 * Search if value exists in the list
	 * 
	 * @param T value
	 * @return integer if found return the index of a node, not found -1
	 */
	public int search(T value) {
		SingleNode<T> node = this.head;
		int i = 0;
		while (node != null) {
			if (node.getValue() == value) {
				break;
			}
			i++;
			node = node.getNext();
		}
		
		return node == null? -1 : i;
	}

	/**
	 * Go through all items in the list and print it out
	 */
	public void traverse() {
		SingleNode<T> node = this.head;
		while (node != null) {
			System.out.print(" " + node.getValue());
			node = node.getNext();
		}
	}

	/**
	 * Count the number of items in the list
	 * 
	 * @return
	 */
	public int count() {
		if (this.head == null) {
			return 0;
		}

		int count = 0;
		SingleNode<T> node = this.head;
		while (node != null) {
			node = node.getNext();
			count++;
		}

		return count;
	}

	/**
	 * Get an item at given index
	 * @param integer index
	 * @return T
	 * @throws IndexOutOfBoundsException
	 */
	public T get(int index) {
		if (index < 0 || index >= this.count()) {
			throw new IndexOutOfBoundsException("Index is out of bound.");
		}

		SingleNode<T> node = this.head;
		if(node == null) {
			return null;
		}
		
		int i = 0;
		while (i != index) {
			node = node.getNext();
			i++;
		}

		return node.getValue();

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SingleNode<T> node = this.head;
		sb.append("[");
		while (node != null) {
			sb.append(node.getValue());
			sb.append(",");
			node = node.getNext();
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}
}
