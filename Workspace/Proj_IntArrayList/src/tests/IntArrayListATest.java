/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import version_01.IntArrayList;

/**
 * @author E
 *
 */
class IntArrayListATest {
	IntArrayList testList;

	/**
	 * Test method for {@link version_01.IntArrayList#IntArrayList()}.
	 */
	@Test
	void testIntArrayList() {
		testList = new IntArrayList();
		System.out.println("Test of Default Constructor:");
		System.out.println("\tSize: " + testList.size());
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			assertEquals(0, testList.get(i), "Index " + i + "failed test.");
		}
		System.out.println("\tTest passed for generated indecies 0 - " + IntArrayList.DEFAULT_CAPACITY);
		System.out.println("---------------------------------------------------------------------------------------");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#IntArrayList(int)}.
	 */
	@Test
	void testIntArrayListInt() {
		int capacity = 20;
		testList = new IntArrayList(capacity);
		System.out.println("Test of Constructor with specified capacity:");
		System.out.println("\tSize: " + testList.size());
		for (int i = 0; i < capacity; i++) {
			assertEquals(0, testList.get(i), "Index " + i + "failed test.");
		}	
		System.out.println("\tTest passed for generated indecies 0 - " + capacity);
		System.out.println("---------------------------------------------------------------------------------------");

	}

	/**
	 * Test method for {@link version_01.IntArrayList#add(int)}.
	 */
	@Test
	void testAddInt() {
		int capacity = 20;
		testList = new IntArrayList(capacity);
		System.out.println("Test of Constructor with specified capacity:");	}

	/**
	 * Test method for {@link version_01.IntArrayList#add(int, int)}.
	 */
	@Test
	void testAddIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#get(int)}.
	 */
	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#indexOf(int)}.
	 */
	@Test
	void testIndexOf() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#remove(int)}.
	 */
	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#size()}.
	 */
	@Test
	void testSize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#toString()}.
	 */
	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
