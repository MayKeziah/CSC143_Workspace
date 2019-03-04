/**
 * 
 */
package lists;

/**
 * <p> An ArrayList is a data structure for storing and manipulating a set of Objects.
 * 
 * @version 01
 * @author E
 */
public class ArrayList<T> implements List<T> {
	/**
	 * The internal data structure.
	 * */
	private T[] element; 
	
	/**
	 * The current number of elements stored in the ArrayList
	 * */
	private int size; 	   
	
	/**
	 * 	The initialized capacity for a default ArrayList (10).
	 * */
	public static final int DEFAULT_CAPACITY = 10; 
			
	/**
	 * The value returned if an element is not found in the ArrayList (-1).
	 * */
	public static final int NOT_FOUND = -1;
	
	/**
	 * Sets the capacity of the ArrayList to default (10).
	 * */
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Cannot accept negative numbers.
	 * 
	 * @param capacity sets the capacity of the ArrayList to the given integer.
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {	
		checkOutRange(capacity, capacity);
		element = (T[]) new Object[capacity];
		size = 0;
	}
	
	/**
	 * (mutator)
	 * <br> Appends a value to the end of the ArrayList.
	 * <br> Ensures the internal data structure grows as needed to store added integers. 
	 * 
	 * @param value the value to add to the list.
	 * */
	public void add(T value) {
		add(size, value);
	}
	
	/**
	 * (mutator)
	 * <br> Inserts the given value at the given index in the ArrayList.
	 * <br> Shifts all subsequent values to the right one position.
	 * <br> Ensures the internal data structure grows as needed to store added values. 
	 * <br> Does not accept index values which are negative or  greater than the number of stored elements. 
	 * 
	 * @param index the location to insert the value.
	 * @param value the value to add to the list.
	 * */
	public void add(int index, T value) { 
		checkOutRange(index, size);
		if (element.length == size) { // If there is no more room, expand the data-structure.
			expand();
		}
		shiftRight(index, value); // Add the new value to the given index and shift the following values to the right.
		size++;
	}
	
	/**
	 * (private-helper method) 
	 * <br> checks if the given number is negative. If yes, it throws an exception. If no, it does nothing.
	 * <br> checks if the given number is greater than the valid range. If yes, it throws an exception. If no, it does nothing.
	 * */
	private void checkOutRange(int check, int max) {
		if(check < 0) { 
			throw new IndexOutOfBoundsException("Index cannot be negative. Index = " + check);
		}if(check > max) {
			throw new IndexOutOfBoundsException("Index cannot be greater than valid range. Index = " + check + ", Max = " + max);
		}
	}

	/**
	 * (private-mutator-helper method) 
	 * <br> Increases the capacity of the internal data structure.
	 * */
	@SuppressWarnings("unchecked")
	private void expand() {
		T[] temp = (T[]) new Object[size + DEFAULT_CAPACITY]; // Create a new Array with more room
		for (int i = 0; i < size; i++) { // Copy the current array to the new array
			temp[i] = element[i];
		}
		element = temp; 
	}
	
	/**
	 * (accessor)
	 * <br> Returns the value stored at the given index location.
	 * <br> Does not accept index values that are negative, or greater than or equal to the number of stored values.
	 *  
	 * @param index the location of the value to return.
	 * @return the value stored at the given index.
	 * */
	public T get(int index) {
		checkOutRange(index, size - 1);
		return element[index];
	}
	
	/**
	 * Searches for the location (index) of a given value and returns that location.
	 * 
	 * @param value the value to search for
	 * @return the location of the given value, -1 if not found.
	 * */
	public int indexOf(T value) {
		for (int i = 0; i < size; i ++) {
			if(element[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * (mutator)
	 * <br> Removes the value at the given location.
	 * <br> Shifts all subsequent values to the left one position.
	 * <br> Does not accept index values that are negative, or greater than or equal to the number of stored values.
	 * 
	 * @param index the location of the value to remove.
	 * */
	public void remove(int index) { 
		checkOutRange(index, size - 1);
		shiftLeft(index);
		size--;
	}
	
	/**
	 * (private-mutator-helper method) 
	 * <br> Shifts the contents of an integer list to the left by one position starting at the given index
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
	 * (private-mutator-helper method) 
	 * <br> Shifts the contents of 'element' to the right by one position from the given index to element indexed at size. 
	 * <br> fills the given index location with the given value.
	 * 
	 * @param the location to insert the value.
	 * @param the value to insert at the given location.
	 * */
	private void shiftRight(int index, T value) {
		for(int i = size; i > index; i--) { // Shift values right one position from the given index to the end of the stored values.
			element[i] = element[i-1];
		}
		element[index] = value;				// Store the given value in the given index.
	}
	
	/**
	 * (accessor)
	 * 
	 * @return The number of locations (size) occupied in the ArrayList.
	 * */
	public int size() {
		return size;
	}
	
	/**
	 * (accessor)
	 * 
	 * @return a string representation of the ArrayList in form: "[Obj0, Obj1, . . . , ObjSize-1]"
	 * */
	public String toString() {
		String toReturn = "[";
		if(size == 0) { // If the data-structure is empty, return "[]"
			return toReturn + "]";
		}
		for (int i = 0; i < size - 1; i++) { 
			toReturn += element[i] + ", ";
		}
		return toReturn + element[size-1] + "]";
	}
}
