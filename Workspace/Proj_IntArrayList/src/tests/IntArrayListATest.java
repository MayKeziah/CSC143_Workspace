/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		testList.add(toAdd);
		System.out.println("\tList after .add(" + toAdd+ ") called:\n\t" + testList);
		assertEquals(toAdd, testList.get(0), "Index " + 0 + " does not equal the added value.");
		for (int i = 1; i < testList.size(); i++) {
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
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		System.out.println("Test of Mutator method add(int, int):");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			assertEquals(i, testList.get(i), "Index " + i + " failed test.");
		}
		testList.add(atIndex, toAdd);
		System.out.println("\tList after .add(" + atIndex +", " + toAdd + ") called:\n\t" + testList);
		assertEquals(toAdd, testList.get(atIndex), "Index " + atIndex + " does not equal the added value, " + toAdd + ".");
		for (int i = 1; i < IntArrayList.DEFAULT_CAPACITY + 1; i++) {
			assertEquals(i - 1, testList.get(i), "Index " + i + " failed test.");
		}
	}

	/**
	 * Test method for {@link version_01.IntArrayList#get(int)}.
	 */
	@Test
	void testGet() {
		System.out.println("---------------------------------------------------------------------------------------");
		testList = new IntArrayList();
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		System.out.println("Test of Accessor method get(int):");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY - 1; i++) {
			assertEquals(i, testList.get(i), "Index " + i + " failed test.");
		}
		System.out.println("\tList after .get(int) called:\n\t" + testList);
		System.out.println("\tSize after .get(int) called:\n\t" + testList.size());
	}

	/**
	 * Test method for {@link version_01.IntArrayList#indexOf(int)}.
	 */
	@Test
	void testIndexOf() {
		System.out.println("---------------------------------------------------------------------------------------");
		testList = new IntArrayList();
		int outOfRange = 200;
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		System.out.println("Test of Method indexOf(int):");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY - 1; i++) {
			assertEquals(i, testList.indexOf(i), "Index " + i + " failed test.");
		}
		assertEquals(IntArrayList.NOT_FOUND, testList.indexOf(outOfRange), "Index-not-found failed test.");
		System.out.println("\tList after .indexOf(int) called:\n\t" + testList);
	}

	/**
	 * Test method for {@link version_01.IntArrayList#remove(int)}.
	 */
	@Test
	void testRemove() {
		System.out.println("---------------------------------------------------------------------------------------");
		int removeIndex = 0;
		testList = new IntArrayList();
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		System.out.println("Test of Mutator method remove(int):");	
		System.out.println("\tInitial list generated:\n\t" + testList);
		testList.remove(removeIndex);
		System.out.println("\tList after .remove(" + removeIndex + ") called:\n\t" + testList);
		for (int i = 1; i < IntArrayList.DEFAULT_CAPACITY - 1; i++) {
			assertEquals(i, testList.get(i - 1), "Index " + i + " failed test.");
		}
	}

	/**
	 * Test method for {@link version_01.IntArrayList#size()}.
	 */
	@Test
	void testSize() {
		System.out.println("---------------------------------------------------------------------------------------");
		testList = new IntArrayList();
		assertEquals(0, testList.size(), "Initial size does not equal 0.");

		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		System.out.println("Test of Accessor method size():");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		assertEquals(IntArrayList.DEFAULT_CAPACITY, testList.size(), "Size does not equal the number of elements stored.");
		System.out.println("\tList after .size(int) called:\n\t" + testList);
		System.out.println("\tSize after .size(int) called:\n\t" + testList.size());
	}

	/**
	 * Test method for {@link version_01.IntArrayList#toString()}.
	 */
	@Test
	void testToString() {
		System.out.println("---------------------------------------------------------------------------------------");
		testList = new IntArrayList();
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		System.out.println("Test of Accessor method toString():");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", testList.toString(), "String returned by toString does not equal the desired String.");
		System.out.println("\tList after .toString(int) called:\n\t" + testList);
		System.out.println("\tSize after .toString(int) called:\n\t" + testList.size());
	}

}
