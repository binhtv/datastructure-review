package vn.binhtv.datastructure.list.single;

/**
 * This class is T type singly Linked List.
 * The class provides some methods to accomplish the tasks as below
 * <p>
 * 1. Append an element into the Linked List
 * <p>
 * 2. Remove the tail element from a Linked List
 * <p>
 * 3. Remove all element in the Linked List that is great than a target value
 * <p>
 * 4. Traverse the list
 * @author binhtran
 */
public class LinkedList<T> {
	private SingleNode<T> head = null;
	
	/**
	 * Append new T into the end of the list
	 * @param T value the value will be appended
	 * @return boolean true on success otherwise false
	 */
	public boolean append(T value) {
		SingleNode<T> newNode = new SingleNode<T>(value);
		if(this.head == null) {
			this.head = newNode;
			return true;
		}
		
		SingleNode<T> node = this.head;
		while(node.getNext() != null) {
			node = node.getNext();
		}
		node.setNext(newNode);
		
		return true;
	}
	
	/**
	 * Insert new T into given index
	 * @param T the value of item
	 * @param int at the index
	 * @return boolean true on success otherwise false
	 * @throws IndexOutOfBoundsException 
	 */
	public boolean append(T value, int index) {
		if(index < 0 || index > this.count()) {
			throw new IndexOutOfBoundsException("The index is out of bound.");
		}
		SingleNode<T> newNode = new SingleNode<T>(value);
		int cIndex = 0;
		SingleNode<T> node = this.head;
		SingleNode<T> prevNode = null;
		while(cIndex != index) {
			prevNode = node;
			node = node.getNext();
			cIndex++;
		}
		
		if(node == this.head) {
			newNode.setNext(node);
			this.head = newNode;
		} else {
			newNode.setNext(node);
			prevNode.setNext(newNode);
		}
		
		return true;
	}
	
	/**
	 * Remove a node from the end of the list
	 * @return boolean true on success otherwise false
	 */
	public boolean remove() {
		SingleNode<T> node = this.head;
		if(node == null) {
			return false;
		}
		SingleNode<T> next = node.getNext();
		while(next.getNext() != null) {
			if(next.getNext().getNext() == null) {
				node = next;
			}
			next = next.getNext();
		}
		next = null;
		node.setNext(null);
		
		return true;
	}
	
	/**
	 * Remove all nodes from the list
	 * @return boolean true on success otherwise false
	 */
	public boolean removeAll() {
		while(this.head != null) {
			this.head = this.head.getNext();
		}
		
		return true;
	}
	
	/**
	 * Search if value exists in the list
	 * @param T value
	 * @return {@link SingleNode} item on found otherwise null
	 */
	public SingleNode<T> search(T value) {
		SingleNode<T> node = this.head;
		while(node != null) {
			if(node.getValue() == value) {
				return node;
			}
			
			node = node.getNext();
		}
		return null;
	}
	
	/**
	 * Go through all items in the list and print it out
	 */
	public void traverse() {
		SingleNode<T> node = this.head;
		while(node != null) {
			System.out.print(" " + node.getValue());
			node = node.getNext();
		}
	}
	
	/**
	 * Count the number of items in the list
	 * @return
	 */
	public int count() {
		if(this.head == null) {
			return 0;
		}
		
		int count = 0;
		SingleNode<T> node = this.head;
		while(node != null) {
			node = node.getNext();
			count++;
		}
		
		return count;
	}
}
