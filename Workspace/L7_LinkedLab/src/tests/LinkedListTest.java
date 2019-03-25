/**
 * 
 */
package tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import links.Iterator;
import links.LinkedList;
import links.LinkedList.Node;

/**
 * @author E
 *
 */
class LinkedListTest {
	LinkedList<String> testLinked;
	Node	  <String> testFront;
	String breakLine = "-----------------------------------------------------------------------------------";
	

	/**
	 * Test method for {@link links.LinkedList#LinkedList()}.
	 */
	@Test
	final void testLinkedList() {
		System.out.println(breakLine);
		System.out.println("Testing Default Constructor:\n");
		
		/**
		 * New String LinkedList with no Nodes.
		 */
		testLinked = new LinkedList<String>();
		
		/**
		 * Test that the list exists and the nodes do not.
		 */
		assertNotNull(testLinked);
		assertThrows (IndexOutOfBoundsException.class, () -> testLinked.nodeAt(0));
		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
						 + "the list exists and the front node is null.");
	}

	/**
	 * Test method for {@link links.LinkedList#LinkedList(links.LinkedList.Node)}.
	 */
	@Test
	final void testLinkedListNodeOfE() {
		System.out.println(breakLine);
		System.out.println("Testing Constructor(Node<E>):\n");

		/**
		 * New String LinkedList with one blank Node.
		 */
		testFront  = new Node<String>();
		testLinked = new LinkedList<String>(testFront);

		/**
		 * Tests that the list and front node exist, but that the data is null.
		 */
		assertNotNull(testLinked);
		assertNotNull(testLinked.nodeAt(0));
		assertNull	 (testLinked.nodeAt(0).data);	
		
		/**
		 * Test that the list is circular.
		 */
		assertEquals (testLinked.nodeAt(0), testLinked.nodeAt(0).next);
		assertEquals (testLinked.nodeAt(0), testLinked.nodeAt(0).prev);
		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
						 + "the list exists, the front node is not null, \n"
						 + "the front Node's data is null, and "
						 + "the front's next and prev refer to itself.");
	}

	/**
	 * Test method for {@link links.LinkedList#add(java.lang.Object)}.
	 */
	@Test
	final void testAddE() {
		System.out.println(breakLine);
		System.out.println("Testing add(E):\n");
		
		/**
		 * New String LinkedList with no Nodes, add a node with data = breakLine.
		 */
		testLinked = new LinkedList<String>();
		testLinked.add(breakLine);
		
		/**
		 * The list, node front, and data exist. The data in front equals breakline.
		 */
		assertNotNull(testLinked);
		assertNotNull(testLinked.nodeAt(0));
		assertNotNull(testLinked.nodeAt(0).data);
		assertEquals (testLinked.nodeAt(0).data, breakLine);
		
		/**
		 * Test that the list is circular.
		 */
		assertEquals (testLinked.nodeAt(0), testLinked.nodeAt(0).next);
		assertEquals (testLinked.nodeAt(0), testLinked.nodeAt(0).prev);
		
		/**
		 * Add additional values, test they exist
		 */
		testLinked.add("1");
		assertNotNull(testLinked.nodeAt(1));
		
		testLinked.add("2");
		assertNotNull(testLinked.nodeAt(2));

		testLinked.add("3");
		assertNotNull(testLinked.nodeAt(3));
		
		/**
		 * test Node at index 0: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(1), testLinked.nodeAt(0).next);
		assertEquals (testLinked.nodeAt(3), testLinked.nodeAt(0).prev);
		
		/**
		 * test Node at index 1: created with correct data
		 */
		assertNotNull(testLinked.nodeAt(1).data);
		assertEquals (testLinked.nodeAt(1).data, "1");
		
		/**
		 * test Node at index 1: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(2), testLinked.nodeAt(1).next);
		assertEquals (testLinked.nodeAt(0), testLinked.nodeAt(1).prev);
		
		/**
		 * test Node at index 2: created with correct data
		 */
		assertNotNull(testLinked.nodeAt(2).data);
		assertEquals (testLinked.nodeAt(2).data, "2");
		
		/**
		 * test Node at index 2: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(3), testLinked.nodeAt(2).next);
		assertEquals (testLinked.nodeAt(1), testLinked.nodeAt(2).prev);
		
		/**
		 * test Node at index 3: created with correct data
		 */
		assertNotNull(testLinked.nodeAt(3).data);
		assertEquals (testLinked.nodeAt(3).data, "3");
		
		/**
		 * test Node at index 3: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(0), testLinked.nodeAt(3).next);
		assertEquals (testLinked.nodeAt(2), testLinked.nodeAt(3).prev);
		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: Added 4 nodes and confirmed expected data, prev, and next values.");

	}

	/**
	 * Test method for {@link links.LinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	final void testAddIntE() {
		System.out.println(breakLine);
		System.out.println("Testing add(int, E):\n");
		
		/**
		 * New String LinkedList with no Nodes.
		 */
		testLinked = new LinkedList<String>();
		
		/**
		 * Add values
		 */
		testLinked.add("0");
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		
		/**
		 * Add additional values with add(int, E)
		 * <br> one at the beginning
		 * <br> one at the middle index
		 * <br> one at the end
		 */
		testLinked.add(0, "inserted at 0");
		assertEquals  (testLinked.nodeAt(0).data, "inserted at 0");
		assertEquals  (testLinked.nodeAt(1).data, "0");		
		assertEquals  (testLinked.nodeAt(2).data, "1");		
		assertEquals  (testLinked.nodeAt(3).data, "2");		
		assertEquals  (testLinked.nodeAt(4).data, "3");		
		
		testLinked.add(2, "inserted at 2");
		assertEquals  (testLinked.nodeAt(0).data, "inserted at 0");
		assertEquals  (testLinked.nodeAt(1).data, "0");		
		assertEquals  (testLinked.nodeAt(2).data, "inserted at 2");
		assertEquals  (testLinked.nodeAt(3).data, "1");		
		assertEquals  (testLinked.nodeAt(4).data, "2");		
		assertEquals  (testLinked.nodeAt(5).data, "3");		
		
		testLinked.add(6, "inserted at 6");
		assertEquals  (testLinked.nodeAt(0).data, "inserted at 0");
		assertEquals  (testLinked.nodeAt(1).data, "0");		
		assertEquals  (testLinked.nodeAt(2).data, "inserted at 2");
		assertEquals  (testLinked.nodeAt(3).data, "1");		
		assertEquals  (testLinked.nodeAt(4).data, "2");		
		assertEquals  (testLinked.nodeAt(5).data, "3");		
		assertEquals  (testLinked.nodeAt(6).data, "inserted at 6");
		
		/**
		 * test Node at index 0: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(1), testLinked.nodeAt(0).next);
		assertEquals (testLinked.nodeAt(6), testLinked.nodeAt(0).prev);
		
		/**
		 * test Node at index 1: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(2), testLinked.nodeAt(1).next);
		assertEquals (testLinked.nodeAt(0), testLinked.nodeAt(1).prev);
		
		/**
		 * test Node at index 2: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(3), testLinked.nodeAt(2).next);
		assertEquals (testLinked.nodeAt(1), testLinked.nodeAt(2).prev);
		
		/**
		 * test Node at index 3: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(4), testLinked.nodeAt(3).next);
		assertEquals (testLinked.nodeAt(2), testLinked.nodeAt(3).prev);
		
		/**
		 * test Node at index 4: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(5), testLinked.nodeAt(4).next);
		assertEquals (testLinked.nodeAt(3), testLinked.nodeAt(4).prev);
		
		/**
		 * test Node at index 5: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(6), testLinked.nodeAt(5).next);
		assertEquals (testLinked.nodeAt(4), testLinked.nodeAt(5).prev);
		
		/**
		 * test Node at index 6: prev and next are as expected
		 */
		assertEquals (testLinked.nodeAt(0), testLinked.nodeAt(6).next);
		assertEquals (testLinked.nodeAt(5), testLinked.nodeAt(6).prev);

		/**
		 * test error handling for invalid index (index < 0) (size < index)
		 */
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.add(-1, "NOT VALID"));
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.add(10, "NOT VALID"));

		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
						 + "Added 7 nodes and confirmed expected data, "
						 + "prev, and next values. \n"
						 + "Also confirmed error handling for invalid index.");
	}

	/**
	 * Test method for {@link links.LinkedList#clear()}.
	 */
	@Test
	final void testClear() {
		System.out.println(breakLine);
		System.out.println("Testing clear():\n");
		
		/**
		 * New String LinkedList with no Nodes, cleared
		 */
		testLinked = new LinkedList<String>();
		assertTrue(testLinked.isEmpty());
		assertEquals(testLinked.size(), 0);
		
		testLinked.clear();
		assertTrue(testLinked.isEmpty());
		assertEquals(testLinked.size(), 0);
		
		/**
		 * Add values
		 */
		testLinked.add("0");
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		
		/**
		 * test that isEmpty and size are reporting as expected.
		 */
		assertFalse(testLinked.isEmpty());
		assertEquals(testLinked.size(), 4);
		
		/**
		 * test that after clear, the list is empty and the size is zero.
		 */
		testLinked.clear();
		assertTrue(testLinked.isEmpty());
		assertEquals(testLinked.size(), 0);
		
		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
						 + "Clears list when called.");
	}

	/**
	 * Test method for {@link links.LinkedList#contains(java.lang.Object)}.
	 */
	@Test
	final void testContains() {
		System.out.println(breakLine);
		System.out.println("Testing contains():\n");
		
		/**
		 * New String LinkedList with no Nodes.
		 */
		testLinked = new LinkedList<String>();
		
		/**
		 * Add values
		 */
		testLinked.add("0");
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		
		/**
		 * test that the list contains the expected values
		 */
		assertTrue(testLinked.contains("0"));
		assertTrue(testLinked.contains("1"));
		assertTrue(testLinked.contains("2"));
		assertTrue(testLinked.contains("3"));
		
		/**
		 * test that the list contains the expected values
		 */
		assertFalse(testLinked.contains("NOT VALID"));
		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
						 + "Accurately reports data contained in the list and data not contained.");
	}

	/**
	 * Test method for {@link links.LinkedList#get(int)}.
	 */
	@Test
	final void testGet() {
		System.out.println(breakLine);
		System.out.println("Testing get(int):\n");
		
		/**
		 * New String LinkedList with no Nodes.
		 */
		testLinked = new LinkedList<String>();
		
		/**
		 * Add values
		 */
		testLinked.add("0");
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		
		/**
		 * Test get at every index
		 */
		assertEquals(testLinked.get(0), "0");
		assertEquals(testLinked.get(1), "1");
		assertEquals(testLinked.get(2), "2");
		assertEquals(testLinked.get(3), "3");
		
		/**
		 * test error handling for invalid index (index < 0) (size <= index)
		 */
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.get(10));
		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
				 + "Added 4 nodes and confirmed expected data, \n"
				 + "Also confirmed error handling for invalid index.");
	}

	/**
	 * Test method for {@link links.LinkedList#indexOf(java.lang.Object)}.
	 */
	@Test
	final void testIndexOf() {
		System.out.println(breakLine);
		System.out.println("Testing indexOf(E):\n");
		
		/**
		 * New String LinkedList with no Nodes.
		 */
		testLinked = new LinkedList<String>();
		
		/**
		 * Add values
		 */
		testLinked.add("0");
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		
		/**
		 * Test indexOf at every index
		 */
		assertEquals(testLinked.indexOf("0"), 0);
		assertEquals(testLinked.indexOf("1"), 1);
		assertEquals(testLinked.indexOf("2"), 2);
		assertEquals(testLinked.indexOf("3"), 3);
		
		/**
		 * test handling for entry not found
		 */
		assertEquals(testLinked.indexOf("invalid"), -1);

		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
				 + "Added 4 nodes and confirmed expected search results, \n"
				 + "Also confirmed handling for entry not found.");
	}
	
	/**
	 * Test method for {@link links.LinkedList#isEmpty()}.
	 */
	@Test
	final void testIsEmpty() {
		System.out.println(breakLine);
		System.out.println("Testing isEmpty():\n");
		
		/**
		 * New String LinkedList with no Nodes, test that it is empty.
		 */
		testLinked = new LinkedList<String>();
		assertTrue(testLinked.isEmpty());
		
		/**
		 * New String LinkedList with a front Node, test that it is not empty.
		 */
		testLinked = new LinkedList<String>(new Node<String>(breakLine));
		assertFalse(testLinked.isEmpty());
		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
				 + "List is empty when expected and not empty when expected.");
	}

	/**
	 * Test method for {@link links.LinkedList#iterator()}.
	 */
	@Test
	final void testIterator() {
		System.out.println(breakLine);
		System.out.println("Testing iterator():\n");
		
		/**
		 * New String LinkedList with no Nodes, test that it is empty.
		 */
		testLinked = new LinkedList<String>();
		
		/**
		 * Add values
		 */
		testLinked.add("0");
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		
		
		/**
		 * create iterator
		 */
		final Iterator<String> iterator = testLinked.iterator();
		
		System.out.println(testLinked.get(0));
		int i = 1;
		while(iterator.hasNext())
		{
			assertEquals(iterator.next(), "" + i);
			i++;
		}
		assertThrows(NoSuchElementException.class, () -> iterator.next());
		
		Iterator<String> iterator2 = testLinked.iterator();
		System.out.println(testLinked);
		iterator2.next();
		iterator2.remove();
		System.out.println(testLinked);
		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
				 + "Can traverse the array and remove items from the array, "
				 + "(all except the front and back).");
	}

	/**
	 * Test method for {@link links.LinkedList#nodeAt(int)}.
	 */
	@Test
	final void testNodeAt() {
		System.out.println(breakLine);
		System.out.println("Testing add(int, E):\n");
		
		/**
		 * New String LinkedList with one Node.
		 */
		Node<String> front = new Node<String>("0");
		testLinked = new LinkedList<String>(front);
		
		/**
		 * Add values
		 */
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		
		/**
		 * test nodeAt for each value
		 */
		assertSame(testLinked.nodeAt(0), front);
		assertSame(testLinked.nodeAt(1), front.next);
		assertSame(testLinked.nodeAt(2), front.next.next);
		assertSame(testLinked.nodeAt(3), front.prev);
		
		/**
		 * test error handling for invalid index (index < 0) (size <= index)
		 */
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.nodeAt(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.nodeAt(10));

		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
				 + "Added 4 nodes and confirmed expected node was returned, \n"
				 + "Also confirmed error handling invalid index.");
	}

	/**
	 * Test method for {@link links.LinkedList#remove(int)}.
	 */
	@Test
	final void testRemove() {
		System.out.println(breakLine);
		System.out.println("Testing remove():\n");
		
		/**
		 * New String LinkedList with no Nodes.
		 */
		testLinked = new LinkedList<String>();
		
		/**
		 * Add values
		 */
		testLinked.add("0");
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.remove(4));
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.remove(100));
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.remove(-1));

		
		testLinked.remove(0);
		assertEquals(testLinked.get(0), "1");
		
		testLinked.remove(1);
		assertEquals(testLinked.get(1), "3");
		
		testLinked.remove(1);
		assertEquals(testLinked.size(), 1);
		
		testLinked.remove(0);
		assertEquals(testLinked.size(), 0);
		
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.remove(4));
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.remove(100));
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.remove(-1));
		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
				 + "Added 4 nodes and confirmed each could be removed. \n"
				 + "Also confirmed error handling for invalid index.");
	}

	/**
	 * Test method for {@link links.LinkedList#set(int, java.lang.Object)}.
	 */
	@Test
	final void testSet() {
		System.out.println(breakLine);
		System.out.println("Testing set(int, E):\n");
		
		/**
		 * New String LinkedList with no Nodes.
		 */
		testLinked = new LinkedList<String>();
		
		/**
		 * Add values
		 */
		testLinked.add("0");
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		
		/**
		 * Test data at every index
		 */
		assertEquals(testLinked.get(0), "0");
		assertEquals(testLinked.get(1), "1");
		assertEquals(testLinked.get(2), "2");
		assertEquals(testLinked.get(3), "3");
		
		/**
		 * reset values to reverse order
		 */
		for (int i = 0; i < testLinked.size(); i++) {
			testLinked.set(i, "" + (testLinked.size() - i - 1));
		}
		
		/**
		 * Test data at every index
		 */
		assertEquals(testLinked.get(0), "3");
		assertEquals(testLinked.get(1), "2");
		assertEquals(testLinked.get(2), "1");
		assertEquals(testLinked.get(3), "0");
		
		/**
		 * Test error handling for invalid index
		 */
		
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.set(5, ""));
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.set(100, " "));
		assertThrows(IndexOutOfBoundsException.class, () -> testLinked.set(-1, " . "));

		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
				 + "Added 4 nodes and confirmed each could be reset. \n"
				 + "Also confirmed error handling for invalid index.");

	}

	/**
	 * Test method for {@link links.LinkedList#size()}.
	 */
	@Test
	final void testSize() {
		System.out.println(breakLine);
		System.out.println("Testing size():\n");
		
		/**
		 * New String LinkedList with no Nodes, test size
		 */
		testLinked = new LinkedList<String>();
		assertEquals(testLinked.size(), 0);
		
		/**
		 * New String LinkedList with one Node, test size
		 */
		testLinked = new LinkedList<String>(new Node<String>("0"));
		assertEquals(testLinked.size(), 1);
		
		/**
		 * Add values, test size
		 */
		testLinked.add("1");
		assertEquals(testLinked.size(), 2);
		testLinked.add("2");
		assertEquals(testLinked.size(), 3);
		testLinked.add("3");
		assertEquals(testLinked.size(), 4);
		
		/**
		 * remove values, test size
		 */
		testLinked.remove(3);	
		assertEquals(testLinked.size(), 3);
		testLinked.remove(2);	
		assertEquals(testLinked.size(), 2);
		testLinked.remove(1);	
		assertEquals(testLinked.size(), 1);
		testLinked.remove(0);	
		assertEquals(testLinked.size(), 0);
		
		/**
		 * Add values, test size after clear
		 */
		testLinked.add("0");
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		
		assertEquals(testLinked.size(), 4);
		testLinked.clear();
		assertEquals(testLinked.size(), 0);
		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
				 + "Added 4 nodes, removed, added back, cleared. Size reported as expected.");
	}

	/**
	 * Test method for {@link links.LinkedList#toString()}.
	 */
	@Test
	final void testToString() {
		System.out.println(breakLine);
		System.out.println("Testing toString():\n");
		
		/**
		 * New String LinkedList with no Nodes, test size
		 */
		testLinked = new LinkedList<String>();
		assertEquals(testLinked.toString(), "[ ]");
		
		/**
		 * New String LinkedList with one Node, test size
		 */
		testLinked = new LinkedList<String>(new Node<String>("0"));
		assertEquals(testLinked.toString(), "[0]");
		
		/**
		 * Add values, test size after clear
		 */
		testLinked.add("1");
		testLinked.add("2");
		testLinked.add("3");
		assertEquals(testLinked.toString(), "[0, 1, 2, 3]");

		
		/**
		 * Will only print if successful.
		 */
		System.out.println("Test successful: "
				 + "Returns expected string.");
	}

}
