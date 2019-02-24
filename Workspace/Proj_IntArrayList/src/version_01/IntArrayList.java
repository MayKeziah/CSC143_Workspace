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
	 * <br> Sets the capacity of the IntArrayList to default (10).
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
		if (index >= element.length) {
			throw new IndexOutOfBoundsException("This database is at capacity. The new value was not added.");
		}
		else {
			shiftRight(index, value);
			size++;
		}
	}
	
	//  shiftRight: private mutator helper method for add(int, int)
	// 		Shifts the contents of 'element' to the right by one position from the given index to element indexed at size. 
	// 		fills the given index location with the given value.
	// 	index: the location to insert the value.
	// 	value: the integer to insert at the given location.
	private void shiftRight(int index, int value) {
		for(int i = size; i > index; i--) {
			element[i] = element[i-1];
		}
		element[index] = value;
	}
	
	/**
	 * toString Method: (accessor)
	 * 
	 * @return a string representation of the IntArrayList in form: "[0, 1, . . . , size-1]"
	 * */
	public String toString() {
		String toReturn = "[";
		for (int i = 0; i < size - 1; i++) {
			toReturn += element[i] + ", ";
		}
		return toReturn + element[size-1] + "]";
	}

}
