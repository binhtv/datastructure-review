package binhtv.java.datastructure.list.doubly;

import junit.framework.TestCase;
import vn.binhtv.datastructure.list.doubly.DoublyLinkedList;

public class DoublyLinkedListTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public DoublyLinkedListTest(String testName) {
		super(testName);
	}

	/**
	 * Test delete a item at given index
	 */
	public void testDeleteAt_() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(5);
		list.insert(6);
		assertEquals(5, list.count());
		list.deleteAt(0);
		assertEquals(4, list.count());
		list.deleteAt(3);
		assertEquals(3, list.count());
		list.deleteAt(1);
		assertEquals(2, list.count());

		list.deleteAt(0);
		list.deleteAt(0);
		assertEquals(0, list.count());
		try {
			list.deleteAt(0);
			assertEquals(0, list.count());
			list.deleteAt(-1);
			assertEquals(0, list.count());
			fail("Expected exception");
		} catch (IndexOutOfBoundsException exc) {

		}

	}
}
