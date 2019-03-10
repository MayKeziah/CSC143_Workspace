/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import lists.ArrayList;

/**
 * @author E
 *
 */
class ArrayListTest { //TODO: add iterator test
	ArrayList<String> sList;
	String s;

	/**
	 * Test method for {@link lists.ArrayList#ArrayList()}.
	 */
	@Test
	final void testArrayList() {
		
		/**
		 * Post-Conditions:
		 * <br> accepts children of the Object class as type parameters 
		 * 		and creates an object reference that is not null.
		 * */
		sList = new ArrayList<String>();
		assertNotNull(sList);

	}

	/**
	 * Test method for {@link lists.ArrayList#ArrayList(int)}.
	 */
	@Test
	final void testArrayListInt() {
		/**
		 * Pre-Conditions:
		 * <br> capacity less than zero throws exception.
		 * */
		assertThrows(IndexOutOfBoundsException.class, () -> new ArrayList<String>(-1));
		
		/**
		 * Post-Conditions:
		 * */
		sList = new ArrayList<String>(5);
		assertNotNull(sList);
		
	}

	/**
	 * Test method for {@link lists.ArrayList#add(java.lang.Object)}.
	 */
	@Test
	final void testAddT() {
		sList = new ArrayList<String>();
		
		/**
		 * Post-Conditions:
		 * */
		sList.add("String 1");
		
		assertEquals(sList.size(), 1);
		assertEquals(sList.get(0), "String 1");
		assertFalse(sList.isEmpty());
		assertEquals(sList.indexOf("String 1"), 0);
		assertTrue(sList.contains("String 1"));
				
	}

	/**
	 * Test method for {@link lists.ArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	final void testAddIntT() {
		sList = new ArrayList<String>();
		
		/**
		 * Pre-Conditions:
		 * <br> index greater than size throws exception.
		 * <br> index less than zero throws exception.
		 * */
		assertThrows(IndexOutOfBoundsException.class, () -> sList.add(3, "Fails"));
		assertThrows(IndexOutOfBoundsException.class, () -> sList.add(-1, "Fails"));
		
		/**
		 * Post-Conditions:
		 * */
		s = "s";
		sList.add(s);
		for(int i = 1; i < 5; i++) {
			s += "s";
			sList.add(s);
			assertEquals(sList.get(i), s);
		}
		
		System.out.println(sList);
		
		sList.add(2, "inserted");
		assertEquals(sList.get(2), "inserted");
		
		System.out.println(sList);
		
		s = "sss";
		for (int j = 3; j < 5; j ++) {
			assertEquals(sList.get(j), s);
			s += "s";
		}
				
	}

	/**
	 * Test method for {@link lists.ArrayList#clear()}.
	 */
	@Test
	final void testClear() {
		sList = new ArrayList<String>();
		
		/**
		 * Post-Conditions:
		 * */
		s = "s";
		for(int i = 1; i < 5; i++) {
			sList.add(s + i);
			assertEquals(sList.get(i - 1), s + i);
		}
		sList.clear();
		assertEquals(0, sList.size(), "Size not zero");
		assertTrue(sList.isEmpty(), "List not empty");
				
	}

	/**
	 * Test method for {@link lists.ArrayList#contains(java.lang.Object)}.
	 */
	@Test
	final void testContains() {
		sList = new ArrayList<String>();
		
		/**
		 * Post-Conditions:
		 * */
		s = "s";
		for(int i = 1; i < 5; i++) {
			sList.add(s + i);
			assertEquals(sList.get(i - 1), s + i);
			assertTrue(sList.contains(s + i));
		}
		assertFalse(sList.contains("nope"));
		
	}

	/**
	 * Test method for {@link lists.ArrayList#ensureCapacity(int)}.
	 */
	@Test
	final void testEnsureCapacity() {
		sList = new ArrayList<String>();
		
		/**
		 * Post-Conditions:
		 * */
		for (int i = 0; i < 10; i++) {
			sList.add("" + i);
		}
		assertEquals(10, sList.size());
		sList.add("greater than capacity");
		assertEquals(11, sList.size());
		assertEquals(sList.toString(), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, greater than capacity]");
 
	}

	/**
	 * Test method for {@link lists.ArrayList#get(int)}.
	 */
	@Test
	final void testGet() {
		sList = new ArrayList<String>();
		/**
		 * Pre-Conditions:
		 * <br> index greater than size throws exception.
		 * <br> index less than zero throws exception.
		 * */
		assertThrows(IndexOutOfBoundsException.class, () -> sList.get(3));
		assertThrows(IndexOutOfBoundsException.class, () -> sList.get(-1));
		
		/**
		 * Post-Conditions:
		 * */
		s = "string";
		for(int i = 1; i < 5; i++) {
			sList.add(s + i);
			assertEquals(sList.get(i - 1), s + i);
		}
		
	}

	/**
	 * Test method for {@link lists.ArrayList#indexOf(java.lang.Object)}.
	 */
	@Test
	final void testIndexOf() {
		sList = new ArrayList<String>();
		
		/**
		 * Post-Conditions:
		 * */
		s = "string";
		for(int i = 1; i < 5; i++) {
			sList.add(s + i);
			assertEquals(sList.indexOf(s + i), i - 1);
		}
		assertEquals(sList.indexOf("Fail"), -1);

		
		
	}

	/**
	 * Test method for {@link lists.ArrayList#isEmpty()}.
	 */
	@Test
	final void testIsEmpty() {
		sList = new ArrayList<String>();
		
		/**
		 * Post-Conditions:
		 * */
		assertTrue(sList.isEmpty());
		sList.add("Hello World");
		assertFalse(sList.isEmpty());
		sList.add("Goodbye World");
		sList.remove(1);
		assertFalse(sList.isEmpty());
		sList.clear();
		assertTrue(sList.isEmpty());
		
	}

	/**
	 * Test method for {@link lists.ArrayList#iterator()}.
	 */
	@Test
	final void testIterator() {
		sList = new ArrayList<String>();
		
		/**
		 * Post-Conditions:
		 * */
 
		
		fail("Not yet implemented"); // TODO: Iterator test
	}

	/**
	 * Test method for {@link lists.ArrayList#remove(int)}.
	 */
	@Test
	final void testRemove() {
		sList = new ArrayList<String>();
		/**
		 * Pre-Conditions:
		 * <br> index greater than size throws exception.
		 * <br> index less than zero throws exception.
		 * */
		assertThrows(IndexOutOfBoundsException.class, () -> sList.remove(3));
		assertThrows(IndexOutOfBoundsException.class, () -> sList.remove(-1));
		
		/**
		 * Post-Conditions:
		 * */
		s = "string";
		for(int i = 1; i < 5; i++) {
			sList.add(s + i);
			assertEquals(sList.get(i - 1), s + i);
			assertEquals(sList.size(), i);
		}for (int j = 0; j < 4; j++) {
			sList.remove(0);
			assertEquals(sList.size(), 3 - j);
		}
		assertTrue(sList.isEmpty());
 
	}

	/**
	 * Test method for {@link lists.ArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	final void testSet() {
		sList = new ArrayList<String>();
		/**
		 * Pre-Conditions:
		 * <br> index greater than size throws exception.
		 * <br> index less than zero throws exception.
		 * */
		assertThrows(IndexOutOfBoundsException.class, () -> sList.set(3, "Fails"));
		assertThrows(IndexOutOfBoundsException.class, () -> sList.set(-1, "Fails"));
		/**
		 * Post-Conditions:
		 * */
		s = "string";
		for(int i = 1; i < 5; i++) {
			sList.add(s + i);
			assertEquals(sList.get(i - 1), s + i);
			assertEquals(sList.size(), i);
			sList.set(i - 1, "Muahaha!" + i);
			assertEquals(sList.get(i - 1), "Muahaha!" + i);
			assertEquals(sList.size(), i);
		}
		
	}

	/**
	 * Test method for {@link lists.ArrayList#size()}.
	 */
	@Test
	final void testSize() {
		sList = new ArrayList<String>();
		
		/**
		 * Post-Conditions:
		 * */
		assertEquals(sList.size(), 0);
		sList.add("Hello World");
		assertEquals(sList.size(), 1);
		sList.add("Goodbye World");
		sList.remove(1);
		assertEquals(sList.size(), 1);
		sList.clear();
		assertEquals(sList.size(), 0);
		
	}

	/**
	 * Test method for {@link lists.ArrayList#toString()}.
	 */
	@Test
	final void testToString() {
		sList = new ArrayList<String>();
		
		/**
		 * Post-Conditions:
		 * */
		s = "s";
		sList.add(s);
		for(int i = 1; i < 5; i++) {
			s += "s";
			sList.add(s);
		}
		assertEquals(sList.toString(), "[s, ss, sss, ssss, sssss]");
		
	}

}
