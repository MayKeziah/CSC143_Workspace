/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import lists.ArrayList;

/**
 * @author E
 *
 */
class ArrayListTest {
	ArrayList<String> sList;

	/**
	 * Test method for {@link lists.ArrayList#ArrayList()}.
	 */
	@Test
	final void testArrayList() {
		sList = new ArrayList<String>();
 
		
		assertNotNull(sList);

	}

	/**
	 * Test method for {@link lists.ArrayList#ArrayList(int)}.
	 */
	@Test
	final void testArrayListInt() {
		sList = new ArrayList<String>(5);
		
		assertNotNull(sList);
		
	}

	/**
	 * Test method for {@link lists.ArrayList#add(java.lang.Object)}.
	 */
	@Test
	final void testAddT() {
		sList = new ArrayList<String>();
		
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
		String s = "s";
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
		String s = "s";
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
		String s = "s";
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
 
		
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link lists.ArrayList#get(int)}.
	 */
	@Test
	final void testGet() {
		sList = new ArrayList<String>();
 
		
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link lists.ArrayList#indexOf(java.lang.Object)}.
	 */
	@Test
	final void testIndexOf() {
		sList = new ArrayList<String>();
 
		
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link lists.ArrayList#isEmpty()}.
	 */
	@Test
	final void testIsEmpty() {
		sList = new ArrayList<String>();
 
		
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link lists.ArrayList#iterator()}.
	 */
	@Test
	final void testIterator() {
		sList = new ArrayList<String>();
 
		
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link lists.ArrayList#remove(int)}.
	 */
	@Test
	final void testRemove() {
		sList = new ArrayList<String>();
 
		
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link lists.ArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	final void testSet() {
		sList = new ArrayList<String>();
 
		
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link lists.ArrayList#size()}.
	 */
	@Test
	final void testSize() {
		sList = new ArrayList<String>();
 
		
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link lists.ArrayList#toString()}.
	 */
	@Test
	final void testToString() {
		sList = new ArrayList<String>();
 
		
		fail("Not yet implemented"); // TODO
	}

}
