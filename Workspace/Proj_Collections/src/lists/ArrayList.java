/**
 * 
 */
package lists;

import college.Student;
import utility.Iterator;

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
	 * Cannot accept negative values.
	 * 
	 * @param capacity sets the capacity of the ArrayList to the given integer.
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {	
		
		//Precondition: Capacity cannot be negative
		checkIndex(capacity, capacity);
		
		//Postcondition: instantiate element and size
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
		checkIndex(index, size);
		ensureCapacity(size + 1); // ensureCapacity of the data-structure.
		shiftRight(index, value); // Add the new value to the given index and shift the following values to the right.
		size++;
	}
	
	/**
	 * (private-helper method) 
	 * <br> checks if the given number is negative. If yes, it throws an exception. If no, it does nothing.
	 * <br> checks if the given number is greater than the valid range. If yes, it throws an exception. If no, it does nothing.
	 * 
	 * @param check the index to test
	 * @param range the largest valid index value
	 * */
	private void checkIndex(int check, int range) {
		if(check < 0) { 
			throw new IndexOutOfBoundsException("Value cannot be negative. Value = " + check);
		}if(check > range) {
			throw new IndexOutOfBoundsException("Value cannot be greater than valid range. Value = " + check + ", Max = " + range);
		}
	}
	
	/**
	 * Clears the list of all elements, the size is set to zero.
	 * */
	public void clear() {
		for(int i = 0; i < size; i++) {
			element[i] = null;
		}
		size = 0;
	}
	
	/**
	 * Searches for the given value in the ArrayList (using indexOf) and returns true if found, if not found, it returns false.
	 * 
	 * @param value the value to search for
	 * @return the location of the given value, -1 if not found.
	 * */
	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	/**
	 * (mutator-helper method) 
	 * <br> Increases the capacity of the internal data structure if the elements you are trying to add exceed capacity.
	 * @param capacity the number of elements we plan to have stored. Ex. obj.size() + 3 (where 3 is the number of elements you want to add)
	 * */
	@SuppressWarnings("unchecked") 
	public void ensureCapacity(int capacity) {
		if(capacity > element.length) {
			T[] temp = (T[]) new Object[capacity + 1]; // Create a new Array with more room
			for (int i = 0; i < size; i++) { // Copy the current array to the new array
				temp[i] = element[i];
			}
			element = temp; 
		}
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
		checkIndex(index, size - 1);
		return element[index];
	}
	
	/**
	 * Searches for a given value in the ArrayList and returns its location if found, if not found, it returns -1.
	 * 
	 * @param value the value to search for
	 * @return the location of the given value, -1 if not found.
	 * */
	public int indexOf(T value) {
		for (int i = 0; i < size; i ++) {
			if(element[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Checks to see if there are any objects stored in the ArrayList.
	 * 
	 * @return a boolean to represent whether or not the ArrayList is empty.
	 * */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns an object that can be used to traverse the inner data structure's stored elements
	 * 
	 * @return an iterator to traverse this ArrayList
	 * */
	public Iterator<T> iterator(){
		return new ArrayIterator();
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
		checkIndex(index, size - 1);
		shiftLeft(index);
		size--;
	}
	
	/**
	 * (mutator)
	 * <br> Replaces the value at given index with the given value.
	 * <br> Does not accept index values which are negative or greater than the number of stored elements. 
	 * 
	 * @param index the location of the value to replace.
	 * @param value the value to add to the list.
	 * */
	public void set(int index, T value) {
		checkIndex(index, size - 1);
		element[index] = value;
	}
	
	/**
	 * (private-mutator-helper method) 
	 * <br> Shifts the contents of an integer list to the left by one position starting at the given index
	 *      moving the subsequent elements over the given index.
	 * <br> Sets the last element to null.
	 * 
	 * @param index the index to shift onto.
	 */
	private void shiftLeft(int index) {
		while(index < size - 1) {
			element[index] = element[index + 1];
			index++;
		}
		element[size] = null;
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
	 * @return a string representation of the ArrayList in form: 
	 * "Obj0, 
	 *  Obj1, 
	 *  . . . ,
	 *  ObjSize-1"
	 * */
	public String toFile() {
		String toReturn = "";
		if ((size != 0) && (element[0] instanceof Student)) { // If the data-structure is empty, return "[]"
			for (int i = 0; i < size - 2; i++) { 
				toReturn += ((Student) element[i]).toFile() + "\n";
			}
			toReturn += ((Student) element[size - 1]).toFile();
		}
		return toReturn;
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
	
	/**
	 * Private inner iterator: used to traverse the ArrayList
	 * */
	private class ArrayIterator implements Iterator<T>{
		private int 	index;			//Current position in the list
		private boolean ableToRemove;	//able to remove now?

		/**
		 * Sets the index to zero and ableToRemove to false for this ArrayList
		 * */
		public ArrayIterator() {
			index 		 = 0;
			ableToRemove = false;
		}
		
		/**
		 * Checks to see if the ArrayList has a next stored value
		 * 
		 * @return a boolean representation of whether or not the ArrayList has a next stored value
		 * */
		@Override
		public boolean hasNext() {
			return  index < size();
		}

		/**
		 * Returns the next element in the ArrayList. If there are no more elements, it throws an exception.
		 * 
		 * @return the next element in the ArrayList
		 * */
		@Override
		public T next() {
			if (!hasNext()) {
				throw new IndexOutOfBoundsException("The ArrayList has no more elements. Size = " + size());
			}
			index++;
			ableToRemove = true;
			return get(index - 1);
		}

		/**
		 * If ableToRemove is true, it removes the element at the current index, if false, it throws an exception.
		 * */
		@Override
		public void remove() {
			if(!ableToRemove) {
				throw new IllegalStateException("Unable to remove item.");
			}
			ArrayList.this.remove(index - 1);
			index--;
			ableToRemove = false;
		}
		
	}
}
