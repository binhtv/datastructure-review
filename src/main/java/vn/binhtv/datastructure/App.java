package vn.binhtv.datastructure;

import vn.binhtv.datastructure.list.doubly.DoublyLinkedList;
import vn.binhtv.datastructure.list.single.LinkedList;
import vn.binhtv.datastructure.stack.Stack;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		// list.insert(1);
		// list.insert(2);
		// list.insert(3);
		// list.insert(4);
		//
		// list.insertLast(5);
		//
		// list.insertAfter(6, 3);
		//
		// System.out.println(list);
		// System.out.println(list.count());
		// list.traverse();
		// list.traverseBackward();
		//
		// System.out.println(list.deleteAt(1));
		// System.out.println(list);

		// LinkedList<Integer> list = new LinkedList<Integer>();
		// list.append(1, 0);
		// list.append(2, 0);
		// list.append(3, 0);
		// list.append(4, 3);
		// System.out.println(list);
		// list.removeAt(1);
		// list.removeAt(1);
		// list.removeAt(1);
		// list.removeAt(1);
		// list.removeAt(1);
		// System.out.println(list);
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.peek());
		System.out.println(stack.search(5));
		System.out.println(stack.search(1));
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());

		}
	}
}
