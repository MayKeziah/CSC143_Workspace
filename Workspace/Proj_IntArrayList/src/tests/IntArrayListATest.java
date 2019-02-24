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
		System.out.println("---------------------------------------------------------------------------------------");
		testList = new IntArrayList();
		System.out.println("Test of Default Constructor:");
		System.out.println("\tSize: " + testList.size());
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			assertEquals(0, testList.get(i), "Index " + i + " failed test.");
		}
		System.out.println("\tTest passed for generated indecies 0 - " + IntArrayList.DEFAULT_CAPACITY);
	}

	/**
	 * Test method for {@link version_01.IntArrayList#IntArrayList(int)}.
	 */
	@Test
	void testIntArrayListInt() {
		System.out.println("---------------------------------------------------------------------------------------");
		int capacity = 20;
		testList = new IntArrayList(capacity);
		System.out.println("Test of Constructor with specified capacity:");
		System.out.println("\tSize: " + testList.size());
		for (int i = 0; i < capacity; i++) {
			assertEquals(0, testList.get(i), "Index " + i + " failed test.");
		}	
		System.out.println("\tTest passed for generated indecies 0 - " + capacity);
	}

	/**
	 * Test method for {@link version_01.IntArrayList#add(int)}.
	 */
	@Test
	void testAddInt() {
		System.out.println("---------------------------------------------------------------------------------------");
		int toAdd = 1;
		testList = new IntArrayList();
		System.out.println("Test of Mutator method add(int):");	
		System.out.println("\tInitial list generated:\n\t" + testList);
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			assertEquals(0, testList.get(i), "Index " + i + " failed test.");
		}
		testList.add(toAdd);
		System.out.println("\tList after .add(" + toAdd+ ") called:\n\t" + testList);
		assertEquals(toAdd, testList.get(0), "Index " + 0 + " does not equal the added value.");
		for (int i = 1; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			assertEquals(0, testList.get(i), "Index " + i + " failed test.");
		}
	}

	/**
	 * Test method for {@link version_01.IntArrayList#add(int, int)}.
	 */
	@Test
	void testAddIntInt() {
		System.out.println("---------------------------------------------------------------------------------------");
		int toAdd = 9;
		int atIndex = 0;
		testList = new IntArrayList();
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY - 1; i++) {
			testList.add(i);
		}
		System.out.println("Test of Mutator method add(int, int):");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY - 1; i++) {
			assertEquals(i, testList.get(i), "Index " + i + " failed test.");
		}
		testList.add(atIndex, toAdd);
		System.out.println("\tList after .add(" + atIndex +", " + toAdd + ") called:\n\t" + testList);
		assertEquals(toAdd, testList.get(atIndex), "Index " + atIndex + " does not equal the added value, " + toAdd + ".");
		for (int i = 1; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			assertEquals(i - 1, testList.get(i), "Index " + i + " failed test.");
		}
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