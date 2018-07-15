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
			newNode.setNext(this.head);
			this.head.setPrev(newNode);
			this.head = newNode;
		}
		return true;
	}

	/**
	 * Insert an element into a list from the last
	 * 
	 * @param T
	 *            the value of item
	 * @return true on success otherwise false
	 */
	public boolean insertLast(T value) {
		DoublyNode<T> newNode = new DoublyNode<T>(value);
		if (this.head == null) {
			this.head = newNode;
		} else {
			DoublyNode<T> lastNode = this.head;
			while (lastNode.getNext() != null) {
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(newNode);
			newNode.setPrev(lastNode);
		}

		return true;
	}

	/**
	 * Insert an element into a list after an index
	 * 
	 * @param int
	 *            index
	 * @return true on success otherwise false
	 * @throws IndexOutOfBoundsException
	 */
	public boolean insertAfter(T value, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.count()) {
			throw new IndexOutOfBoundsException("The index is out of bound.");
		}
		DoublyNode<T> newNode = new DoublyNode<T>(value);
		DoublyNode<T> node = this.head;
		if (node == null) {
			this.head = newNode;
		} else {
			int i = 0;
			while (i != index) {
				node = node.getNext();
				i++;
			}
			DoublyNode<T> nextNode = node.getNext();
			newNode.setNext(nextNode);
			if (nextNode != null) {
				nextNode.setPrev(newNode);
			}
			newNode.setPrev(node);
			node.setNext(newNode);
		}

		return true;
	}

	/**
	 * Delete an item at the beginning of the list
	 * 
	 * @return {@link DoublyNode} deleted node
	 */
	public DoublyNode<T> delete() {
		DoublyNode<T> deletedNode = this.head;
		if (deletedNode != null) {
			this.head = deletedNode.getNext();
			deletedNode.setNext(null);
			if (this.head != null) {
				this.head.setPrev(null);
			}
		}

		return deletedNode;
	}

	/**
	 * Delete an item at the end of the list
	 * 
	 * @return {@link DoublyNode} deleted node
	 */
	public DoublyNode<T> deleteLast() {
		DoublyNode<T> lastNode = this.head;
		if (lastNode != null) {
			while (lastNode.getNext() != null) {
				lastNode = lastNode.getNext();
			}

			DoublyNode<T> prevNode = lastNode.getPrev();
			lastNode.setPrev(null);
			if (prevNode != null) {
				prevNode.setNext(null);
			} else {
				this.head = null;
			}
		}

		return lastNode;
	}

	/**
	 * Delete an item at the given index
	 * 
	 * @param index
	 *            the index
	 * @return {@link DoublyNode}
	 * @throws IndexOutOfBoundsException
	 */
	public DoublyNode<T> deleteAt(int index) {
		if (index < 0 || index >= this.count()) {
			throw new IndexOutOfBoundsException("The index is out of bound.");
		}
		DoublyNode<T> node = this.head;
		int i = 0;
		while (i != index) {
			node = node.getNext();
			i++;
		}
		DoublyNode<T> prevNode = node.getPrev();
		DoublyNode<T> nextNode = node.getNext();
		if (prevNode != null && nextNode != null) {// Middle node
			prevNode.setNext(nextNode);
			nextNode.setPrev(prevNode);
			node.setPrev(null);
			node.setNext(null);
		} else if (prevNode != null && nextNode == null) {// Last Node
			prevNode.setNext(null);
			node.setPrev(null);
		} else if (prevNode == null && nextNode != null) {// First Node
			nextNode.setPrev(null);
			node.setNext(null);
			this.head = nextNode;
		} else {// Only node
			this.head = null;
		}

		return node;
	}

	public void traverse() {
		DoublyNode<T> node = this.head;
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node);
			sb.append(" ");
			node = node.getNext();
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		System.out.println(sb);
	}

	public void traverseBackward() {
		DoublyNode<T> lastNode = this.head;
		StringBuilder sb = new StringBuilder();
		if (lastNode != null) {
			while (lastNode.getNext() != null) {
				lastNode = lastNode.getNext();
			}
			while (lastNode != null) {
				sb.append(lastNode);
				sb.append(" ");
				lastNode = lastNode.getPrev();
			}
			if (sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
			System.out.println(sb);
		}
	}

	public int count() {
		int count = 0;
		DoublyNode<T> node = this.head;
		while (node != null) {
			count++;
			node = node.getNext();
		}

		return count;
	}

	@Override
	public String toString() {
		DoublyNode<T> node = this.head;
		StringBuilder sb = new StringBuilder();
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
