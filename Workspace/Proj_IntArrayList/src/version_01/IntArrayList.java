/**
 * 
 */
package version_01;

/**
 * <p> An IntArrayList is a data structure for storing and manipulating a set of integers.
 * 
 * @version 01
 * @author E
 */
public class IntArrayList {
	

	private int[] element; // The internal data structure.
	private int size; 	   // The current number of elements stored in the IntArrayList
	
	/**
	 * 	The initialized capacity for a default IntArrayList (10).
	 * */
	public static int DEFAULT_CAPACITY = 10; 
			
	/**
	 * The value returned if an element is not found in the IntArrayList (-1).
	 * */
	public static int NOT_FOUND = -1;
	
	/**
	 * Default Constructor:
	 * <br> Sets the capacity of the IntArrayList to default.
	 * */
	public IntArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor:
	 * @param capacity sets the capacity of the IntArrayList to the given integer.
	 * */
	public IntArrayList(int capacity) {	//TODO: test for invalid capacities.
		element = new int[capacity];
		size = 0;
	}
	
	/**
	 * Add Method: (mutator)
	 * <br> Appends a value to the end of the IntArrayList.
	 * @param value the integer to add to the list.
	 * */
	public void add(int value) {
		add(size, value);
	}
	
	/**
	 * Add Method: (mutator)
	 * <br> Inserts the given value at the given index in the IntArrayList.
	 * <br> Shifts all subsequent values to the right.
	 * 
	 * @param index the location to insert the value.
	 * @param value the integer to add to the list.
	 * */
	public void add(int index, int value) {//TODO: add a handler for when the index is greater than or equal to the length of the database.
		
	}

}
