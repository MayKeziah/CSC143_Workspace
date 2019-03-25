/**
 * 
 */
package links;

import java.util.NoSuchElementException;

/**
 * @author E
 * @version 1.0
 */

/**
 * Used to store a list of linked objects that store Generic objects.
 */
public class LinkedList<E> implements List<E> {

	/**
	 * Declaration for underlying data structure 
	 */
	
	private Node<E> front;	// reference to the first value in the list
	private int size;		// the number of nodes stored in the list
	
	/**
	 * Constructs an empty list
	 */
	public LinkedList() {
		this(null);
		size = 0;
	}
	
	/**
	 * Constructs a list with the first item
	 */
	public LinkedList(Node<E> front) {
		size = 1;
		if(front != null) {
			makeFront(front);
		}else {
			this.front = front;
		}
	}
	
	/**
	 * Appends the given value to the end of the list 
	 * 
	 * @param value the value to store
	 */
	public void add(E value) {
		if(front == null) {
			makeFront(new Node<E>(value));
		}else {
			Node<E> current = front;
			while(current.next != front) {
				current = current.next;
			}
			current.next = new Node<E>(value, front, current);
			front.prev = current.next;
		}
		size++;
	}
	

	/**
	 * Inserts the given value at the given index of the list 
	 * <br> shifts all subsequent values
	 * 
	 * @param index the location to store the given value
	 * @param value the value to store
	 * @throws IndexOutOfBoundsException for index values outside of the acceptable range.
	 */
	public void add(int index, E value) {
		checkIndex(index, size);
		if((index == 0) && (front == null)) {
			makeFront(new Node<E>(value));
		}else if(index == size) {
			add(value);
		} else {
			Node<E> current = nodeAt(index).prev;
			Node<E> temp 	= current.next;
			current.next = new Node<E>(value, temp, current);
			temp.prev = current.next;
			if(index == 0) {
				front = current.next;
			}
		}
		size++;
	}
	
	
	/**
	 * Checks the given index to make sure it is positive and within a given range
	 * 
	 * @param index the index to test
	 * @param range the largest valid index
	 * @throws IndexOutOfBoundsException for index values outside of the acceptable range.
	 */
	private void checkIndex(int index, int range) {
		if((index > range) || (index < 0)){
			throw new IndexOutOfBoundsException("Index out of range. "
					+ "Index = " + index + ", "
					+ "Range = " + 0 + " - " + range);
		}
	}

	/**
	 * Empties the list when called
	 */
	public void clear() {
		front = null; //TODO add test
		size = 0;
	}

	/**
	 * Establishes whether or not a given value is stored in the list
	 * 
	 * @param value the value to test
	 * @returns true if this list stores the given value, false otherwise.
	 */
	public boolean contains(E value){
		return !(indexOf(value) == -1); //TODO add test
	}

	/**
	 * Returns the value stored in the given location
	 * 
	 * @param index the index of the value to return
	 * @return the value at the given index 
	 * @throws IndexOutOfBoundsException for index values outside of the acceptable range.
	 */
	public E get(int index) {
		checkIndex(index, size - 1);
		return (E) nodeAt(index).data;
	}
	
	/**
	 * Searches the list to find the first occurrence of the given value and returns its location.
	 * 
	 * @param value the value to search for
	 * @return the position of the first occurrence of the given value (-1 if not found)
	 */
	public int indexOf(E value) {
		int index = 0;
		Node<E> current = front;
		do 
		{
			if (current.data.equals(value)) {
				return index;
			}
			index++;
			current = current.next;
		} while(current != front);
		return -1;
	}
	
	/**
	 * Lets you know whether the list is empty
	 * 
	 * @return true if the list is empty and false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return front == null;
	}

	/**
	 * Creates a tool that allows sequential access 
	 * to the contents of the list starting at the 2nd element.
	 * 
	 * @returns a tool you can use to iterate through the current list
	 */
	public Iterator<E> iterator(){
		return new LinkedIterator(); //TODO add test
	}

	/**
	 *  A class for iterating through a linked
	 *  data structure of generic objects.
	 */
	public class LinkedIterator implements Iterator<E> {
	
		/**
		 * 	Tracks the status of the iterations
		 */
		private Node<E> current;		//Tracks the current position
		private boolean ableToRemove;	//Can I remove the current Node?
		
		/**
		 * 	constructs an iterator with current set to
		 *  front.next and ableToRemove set to false.
		 */
		public LinkedIterator(){
			current = (Node<E>) front.next;
			ableToRemove = false;
		}
	
		/**
		 * Checks to see if the iterator has reached the end of the list
		 * 
		 * @return true if there is another value in the list, false otherwise
		 */
		@Override
		public boolean hasNext() {
			return !(current == front);
		}
	
		/**
		 * Starting at the 2nd element, next moves the iterator to the next location in the list. 
		 * 
		 * @return the data stored at the current location
		 * @throws NoSuchElementException when you have reached the end of the list.
		 */
		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			E toReturn = current.data;
			current = current.next;
			ableToRemove = true;
			return toReturn;
		}
	
		/**
		 * Removes the last location accessed in the list.
		 * 
		 * @throws IllegalStateException if you have not yet accessed the location you are trying to remove.
		 */
		@Override
		public void remove() {
			if(!ableToRemove) {
				throw new IllegalStateException("Cannot remove.");
			}
			Node<E> prev2 = current.prev.prev;
			prev2.next = current;
			current.prev = prev2;
			size--;
			ableToRemove = false;
		}
		
	}

	/**
	 * Makes a new front object with the front being the only Node
	 * 
	 * @param elt the new front Node
	 */
	private void makeFront(Node<E> elt) {
		if (front == null){
			front = elt;
			front.next = front;
			front.prev = front;
		}
	}

	/**
	 *  A class for storing a single node of a linked
	 *  data structure of integers.
	 */
	public static class Node<E> {
	
		/**
		 * 	specifies underlying data structure
		 */
		public E  data;			//data stored in the current node
		public Node<E> next;	//link to next node in list
		public Node<E> prev;	//link to previous node in list
		
		/**
		 * 	constructs a node with data = null, link = null
		 */
		public Node() {
			this(null, null, null);
		}
		
		/**
		 * 	constructs a node with data = value, links are null
		 */
		public Node(E value) {
			this(value, null, null);
		}
		
		/**
		 * Constructs a node with given data of generic type  
		 * 
		 * @param data the data to store 
		 * @param next the next node
		 * @param prev the previous node
		 */
		public Node(E data, Node<E> next, Node<E> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
	}

	/**
	 * Returns the element at the given index
	 * 
	 * @param index the location of the element to return
	 * @return reference to the node at the given index 
	 * @throws IndexOutOfBoundsException for index values outside of the acceptable range.
	 */
	public Node<E> nodeAt(int index) {
		checkIndex(index, size - 1);
		Node<E> current  = front;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}
	
	/**
	 * Removes value at the given index 
	 * 
	 * @param index the index to remove from the list
	 * @throws IndexOutOfBoundsException for index values outside of the acceptable range.
	 */
	@Override
	public void remove(int index) {
		checkIndex(index, size - 1);
		if(index == 0) {
			Node<E> temp = front.prev;
			front = front.next;
			front.prev = temp;
		}else {
			Node<E> current = nodeAt(index).next;
			Node<E> prev2 = current.prev.prev;
			prev2.next = current;
			current.prev = prev2;
		}
		size--;
	}
	
	/**
	 * Resets the value stored in the indexed location to the given value
	 * 
	 * @param index the indexed location to reset
	 * @param value the value to insert into the given index
	 */
	@Override
	public void set(int index, E value) {
		nodeAt(index).data = value;
		
	}

	/**
	 * @return the current number of elements in the list 
	 */
	@Override
	public int size() {
//		int count = 0;
//		Node<E> current  = front;
//		 do{
//			current = current.next;
//			count++;
//		}while(current != front);
//		return count;
		return size;
	}
	
	/**
	 * 	@return a comma separated, bracketed version of list 
	 */
	@Override
	public String toString() {
		if(front == null) {
			return "[ ]";
		}else {
			String result = "[" + front.data;
			Node<E> current = front.next;
			while(current != front) {
				result  += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	
}

