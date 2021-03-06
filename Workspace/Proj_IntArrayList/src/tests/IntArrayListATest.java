/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import version_01.IntArrayList;

/**
 * @author E
 *
 */
class IntArrayListATest {
	IntArrayList testList;
	int sizeTest;
	String breakLine = "---------------------------------------------------------------------------------------";

	/**
	 * Test method for {@link version_01.IntArrayList#IntArrayList()}.
	 */
	@Test
	void testIntArrayList() {
		System.out.println(breakLine);
		
		//Create an IntArrayList with a default starting capacity
		testList = new IntArrayList();
		System.out.println("Test of Default Constructor:");
		System.out.println("\tSize: " + testList.size());
		
		//Checks that the reference is not null
		assertNotNull(testList);
		
		//Checks that the size is zero
		assertEquals(0, testList.size());
		
		//Only prints if all tests pass
		System.out.println("\nTest passed: object not null.");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#IntArrayList(int)}.
	 */
	@Test
	void testIntArrayListInt() {
		System.out.println(breakLine);
		
		//The initial capacity to set
		int capacity = 20;
		
		//Create an IntArrayList with a specified starting capacity
		testList = new IntArrayList(capacity);
		System.out.println("Test of Constructor with specified capacity:");
		System.out.println("\tSize: " + testList.size());
		
		//Checks that the reference is not null
		assertNotNull(testList);
		
		//Checks that the size is zero
		assertEquals(0, testList.size());
		
		//Only prints if all tests pass
		System.out.println("\nTest passed: object not null.");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#add(int)}.
	 */
	@Test
	void testAddInt() {
		System.out.println(breakLine);
		
		//The value to add to the list
		int toAdd = 1;
		
		//Creates an IntArrayList object with no filled elements, DEFAULT_CAPACITY, and size = 0
		testList = new IntArrayList();
		System.out.println("Test of Mutator method add(int):");	
		System.out.println("\tInitial list generated:\n\t" + testList);
		
		//Appending add attempt
		testList.add(toAdd);
		System.out.println("\tList after .add(" + toAdd+ ") called:\n\t" + testList);
		
		//Check that the append was successful
		assertEquals(toAdd, testList.get(0), "Index " + 0 + " does not equal the added value.");
		assertEquals(testList.size(), 1);
		
		//Only prints if all tests pass
		System.out.println("\nTest passed: Value added, size incremented.");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#add(int, int)}.
	 */
	@Test
	void testAddIntInt() {
		System.out.println(breakLine);
		
		//The value to add to the list
		int toAdd = -5;
		
		//Will insert 'toAdd' at location: indexOf
		int atIndex = 0;
		testList = new IntArrayList();
		
		//Populated to size DEFAULT_CAPACITY, values set to index location
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		System.out.println("Test of Mutator method add(int, int):");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		
		//Test that all values equal their index location
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			assertEquals(i, testList.get(i), "Index " + i + " failed test.");
		}
		
		//Attempt to insert 'toAdd' at location: indexOf
		testList.add(atIndex, toAdd);
		System.out.println("\tList after .add(" + atIndex +", " + toAdd + ") called:\n\t" + testList);
		
		//Test that toAdd was successfully added at atIndex 
		assertEquals(toAdd, testList.get(atIndex), "Index " + atIndex + " does not equal the added value, " + toAdd + ".");
		
		//Test that the following values were shifted to the right one position
		for (int i = 1; i < IntArrayList.DEFAULT_CAPACITY + 1; i++) {
			assertEquals(i - 1, testList.get(i), "Index " + i + " failed test.");
		}
		
		//Test that the size was incremented
		assertEquals(IntArrayList.DEFAULT_CAPACITY + 1, testList.size());
		
		//Test at a middle index
		testList.add(atIndex + 5, toAdd);
		assertEquals(toAdd, testList.get(atIndex + 5), "Index " + atIndex + " does not equal the added value, " + toAdd + ".");
		
		//Only prints if all tests pass
		System.out.println("\nTest passed: Value added at given index, size incremented.");

	}

	/**
	 * Test method for {@link version_01.IntArrayList#get(int)}.
	 */
	@Test
	void testGet() {
		System.out.println(breakLine);
		testList = new IntArrayList();
		
		//Populated to size DEFAULT_CAPACITY, values set to index location
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		
		//Initial size
		sizeTest = testList.size();
		System.out.println("Test of Accessor method get(int):");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		
		//Test that returned values for get(int) at all indecies match expected values
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY - 1; i++) {
			assertEquals(i, testList.get(i), "Index " + i + " failed test.");
		}
		System.out.println("\tList after .get(int) called:\n\t" + testList);
		System.out.println("\tSize after .get(int) called:\n\t" + testList.size());
		
		//Testing for unwanted size change
		assertEquals(sizeTest, testList.size());
		
		//Only prints if all tests pass
		System.out.println("\nTest passed: Values returned for all indecies verified, size unchanged.");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#indexOf(int)}.
	 */
	@Test
	void testIndexOf() {
		System.out.println(breakLine);
		testList = new IntArrayList();
		
		//A value not in the IntArrayList
		int outOfRange = 200;
		
		//Populated to size DEFAULT_CAPACITY, values set to index location
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) { 
			testList.add(i); //All values equal their index
		}
		
		//Initial size
		sizeTest = testList.size(); 
		System.out.println("Test of Method indexOf(int):");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		
		//Test that all elements populated are searchable
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY - 1; i++) { 
			assertEquals(i, testList.indexOf(i), "Index " + i + " failed test.");
		}
		
		//Test that a value not found returns NOT_FOUND
		assertEquals(IntArrayList.NOT_FOUND, testList.indexOf(outOfRange), "Index-not-found failed test.");
		System.out.println("\tList after .indexOf(int) called:\n\t" + testList);
		
		//Testing for unwanted size change
		assertEquals(sizeTest, testList.size()); 
		
		//Only prints if all tests pass
		System.out.println("\nTest passed: indecies returned for all values verified, size unchanged.");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#remove(int)}.
	 */
	@Test
	void testRemove() {
		System.out.println(breakLine);
		testList = new IntArrayList();
		
		//The index location of the value to remove
		int removeIndex = 0;
		
		//Populated to size DEFAULT_CAPACITY, values set to index location
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		
		//Initial size
		sizeTest = testList.size();
		System.out.println("Test of Mutator method remove(int):");	
		System.out.println("\tInitial list generated:\n\t" + testList);
		
		//Attempt to remove the the value at location: removeIndex
		testList.remove(removeIndex);
		System.out.println("\tList after .remove(" + removeIndex + ") called:\n\t" + testList);
		
		//Testing for expected size change
		assertEquals(--sizeTest, testList.size()); 
		
		//Test that subsequent values are shifted to the left (expect index 0 - 8 to be 1 - 9).
		for (int i = 1; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			assertEquals(i, testList.get(i - 1), "Index " + i + " failed test.");
		}
		
		//Test remove for all remaining indecies (index 0 becomes 9)
		for (int i = testList.size() - 2; i >= 0; i--) {
			testList.remove(i);
			
			//Testing for expected size change
			assertEquals(--sizeTest, testList.size()); 
		}
		
		//Only prints if all tests pass
		System.out.println("\nTest passed: remove function verified for all index values, size change confirmed.");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#size()}.
	 */
	@Test
	void testSize() {
		System.out.println(breakLine);
		testList = new IntArrayList();
		
		//Test that initial size is 0
		assertEquals(0, testList.size(), "Initial size does not equal 0.");

		//Populated to size DEFAULT_CAPACITY, values set to index location
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		System.out.println("Test of Accessor method size():");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		
		//Tests for expected size change from 0 to DEFAULT_CAPACITY after add(int) called
		assertEquals(IntArrayList.DEFAULT_CAPACITY, testList.size(), "Size does not equal the number of elements stored.");
		System.out.println("\tList after .size(int) called:\n\t" + testList);
		System.out.println("\tSize after .size(int) called:\n\t" + testList.size());
		
		//Test for expected size change from DEFAULT_CAPACITY to DEFAULT_CAPACITY - 1 when remove(int) is called
		testList.remove(IntArrayList.DEFAULT_CAPACITY / 2);
		assertEquals(IntArrayList.DEFAULT_CAPACITY - 1, testList.size(), "Size does not equal the number of elements stored.");
		
		//Only prints if all tests pass
		System.out.println("\nTest passed: size confirmed for constructor, add(int), add(int, int), and remove(int).");
	}

	/**
	 * Test method for {@link version_01.IntArrayList#toString()}.
	 */
	@Test
	void testToString() {
		System.out.println(breakLine);
		testList = new IntArrayList();
		
		//test that the returned string equals the expected return
		assertEquals("[]", testList.toString(), "String returned by toString does not equal the desired String.");

		
		//Populated to size DEFAULT_CAPACITY, values set to index location
		for (int i = 0; i < IntArrayList.DEFAULT_CAPACITY; i++) {
			testList.add(i);
		}
		System.out.println("Test of Accessor method toString():");	
		System.out.println("\tStarting list generated:\n\t" + testList);
		
		//test that the returned string equals the expected return
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", testList.toString(), "String returned by toString does not equal the desired String.");
		System.out.println("\tList after .toString(int) called:\n\t" + testList);
		System.out.println("\tSize after .toString(int) called:\n\t" + testList.size());
		
		//Test for expected size change from DEFAULT_CAPACITY to DEFAULT_CAPACITY - 1 when remove(int) is called
		assertEquals(IntArrayList.DEFAULT_CAPACITY, testList.size(), "Size does not equal the number of elements stored.");

		//Only prints if all tests pass
		System.out.println("\nTest passed: returns expected string when full and when empty.");
	}

}
