package vn.binhtv.datastructure.list.doubly;

/**
 * This class is T type doubly Linked List. The class provides some methods to
 * accomplish the tasks as below
 * <p>
 * 1. Insert an element into the Doubly Linked List
 * <p>
 * 2. Insert an element into the Doubly Linked List from the last
 * <p>
 * 3. Insert an element into the Doubly Linked List after an index
 * <p>
 * 4. Remove an element from the beginning of the Doubly Linked List
 * <p>
 * 5. Remove an element from the last of the Doubly Linked List
 * <p>
 * 6. Remove an element at the position of the Doubly Linked List
 * <p>
 * 7. Traverse
 * <p>
 * 8. Traverse the list
 * <p>
 * 9.
 * 
 * @author binhtran
 */
public class DoublyLinkedList<T> {
	private DoublyNode<T> head = null;

	/**
	 * Insert an element into a list from the beginning
	 * 
	 * @param T
	 *            the value of item
	 * @return boolean true on success otherwise false
	 */
	public boolean insert(T value) {
		DoublyNode<T> newNode = new DoublyNode<T>(value);
		if (this.head == null) {
			this.head = newNode;
		} else {
			newNode.setNext(this.head.getNext());
			this.head = newNode;
		}
		return true;
	}

	/**
	 * Insert an element into a list from the last
	 * 
	 * @return true on success otherwise false
	 */
	public boolean insertLast() {
		return false;
	}

	/**
	 * Insert an element into a list after an index
	 * 
	 * @return true on success otherwise false
	 */
	public boolean insertAfter() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public DoublyNode<T> delete() {
		return null;
	}

	public DoublyNode<T> deleteLast() {
		return null;
	}

	public DoublyNode<T> deleteAt() {
		return null;
	}

	public void traverse() {

	}

	public void traverseBackward() {

	}
}
