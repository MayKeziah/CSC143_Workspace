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
	
	/**
	 * The internal data structure.
	 * */
	private int[] element; 
	
	/**
	 * The current number of elements stored in the IntArrayList
	 * */
	private int size; 	   
	
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
	 * 
	 * @param capacity sets the capacity of the IntArrayList to the given integer.
	 * */
	public IntArrayList(int capacity) {	//TODO: test for invalid (negative) capacities.
		element = new int[capacity];
		size = 0;
	}
	
	/**
	 * Add Method: (mutator)
	 * <br> Appends an integer value to the end of the IntArrayList.
	 * <br> Ensures the internal data structure grows as needed to store added integers. 
	 * 
	 * @param value the integer to add to the list.
	 * */
	public void add(int value) {
		add(size, value);
	}
	
	/**
	 * Add Method: (mutator)
	 * <br> Inserts the given value at the given index in the IntArrayList.
	 * <br> Shifts all subsequent values to the right one position.
	 * <br> Ensures the internal data structure grows as needed to store added values. 
	 * 
	 * @param index the location to insert the value.
	 * @param value the integer to add to the list.
	 * */
	public void add(int index, int value) { //TODO: add a handler for when the index is greater than or equal to the length of the database.
		if(index < 0) {
			throw new IndexOutOfBoundsException("Index cannot be negative. Index = " + index);
		}if(index > size) {
			throw new IndexOutOfBoundsException("Index cannot be greater than size. Index = " + index + ", Size = " + size);
		}if (element.length == size) {
			expand();
		}
		shiftRight(index, value);
		size++;
	}
	
	/**
	 * expand for add(int, int): (private-mutator-helper method) 
	 * <br> Increases the capacity of the internal data structure.
	 * */
	private void expand() {
		int[] temp = new int[size + DEFAULT_CAPACITY];
		for (int i = 0; i < size; i++) {
			temp[i] = element[i];
		}
		element = temp;
	}
	
	/**
	 * Get Method: (accessor)
	 * <br> Returns the value stored at the given index location.
	 * 
	 * @param index the location of the value to return.
	 * */
	public int get(int index) {
		return element[index];
	}
	
	/**
	 * IndexOf Method: 
	 * <br> searches for the location (index) of a given value and returns that location.
	 * 
	 * @param value the value to search for
	 * @return the location of the given value, -1 if not found.
	 * */
	public int indexOf(int value) {
		int low = 0;
		int high = element.length - 1;
		int mid = (high + low)/2;
		while(low <= high) {
			if(element[mid] == value) {
				return mid;
			}if (element[mid] > value) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
			mid = (high + low)/2;
		}
		return NOT_FOUND;
	}
	
	/**
	 * Remove Method: (mutator)
	 * <br> Removes the value at the given location.
	 * <br> Shifts all subsequent values to the left one position.
	 * 
	 * @param index the location of the value to remove.
	 * */
	public void remove(int index) { //TODO: add a handler for invalid index values
		shiftLeft(index);
		size--;
	}
	
	/**
	 * shiftLeft for remove(int): (private-mutator-helper method) 
	 * <br> Shifts the contents of an integer list to the left by one position from the given index
	 * <br> moving the subsequent elements over the given index.
	 * 
	 * @param index the index to shift onto.
	 */
	private void shiftLeft(int index) {
		while(index < size - 1) {
			element[index] = element[index + 1];
			index++;
		}
	}
	
	/**
	 * shiftRight for add(int, int): (private-mutator-helper method) 
	 * <br> Shifts the contents of 'element' to the right by one position from the given index to element indexed at size. 
	 * <br> fills the given index location with the given value.
	 * 
	 * @param the location to insert the value.
	 * @param the integer to insert at the given location.
	 * */
	private void shiftRight(int index, int value) {
		for(int i = size; i > index; i--) {
			element[i] = element[i-1];
		}
		element[index] = value;
	}
	
	/**
	 * Size method: (accessor)
	 * 
	 * @return The number of locations (size) occupied in the IntArrayList.
	 * */
	public int size() {
		return size;
	}
	
	/**
	 * toString Method: (accessor)
	 * 
	 * @return a string representation of the IntArrayList in form: "[0, 1, . . . , size-1]"
	 * */
	public String toString() {
		String toReturn = "[";
		if(size == 0) {
			return toReturn + "]";
		}
		for (int i = 0; i < size - 1; i++) {
			toReturn += element[i] + ", ";
		}
		return toReturn + element[size-1] + "]";
	}

}
