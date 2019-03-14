package group;

/**********************************************************************
 * <p> Uses an array as the internal data structure to store 
 *     a list of integers.
 * </p>
 **********************************************************************/
public class ArrayList<T> {

	/***********************************************************
	 *	data fields
	 * 	declaration for underlying data structure and its size. 
	 ***********************************************************/
	private T[] element;		// list of elements
	private int size;			// number of occupied elements in list
	
	public static final int DEFAULT_CAPACITY = 100;
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayList(int capacity) {
		
	}
	
	public void add(T value) {
	}
	
	public void add(int index, T value) {
		
	}
	
	public void clear() {
		
	}
	
	public boolean contains(T value) {
		return false; 
	}
	
	public T get(int index) {
		
		return element[index];
	}
	
	public int indexOf(T value) {
		
		return -1;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}
	
	public void remove(int index) {
		
	}
	
	public void set(int index, T value) {
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		if(size == 0) {
			return "[ ]";
		}else {
			String result = "[ " + element[0];
			for(int i = 1; i < size; i++) {
				result  += ", " + element[i];
			}
			result += " ]";
			return result;
		}
	}
	
	private class ArrayIterator implements Iterator<T>{
		private int 		 index;				// current position in list.
		
		/***************************************************
		 * 	constructs an iterator for the given list
		 ***************************************************/
		public ArrayIterator() {
			index  	 	 = 0;
		}
		
		public boolean hasNext() {
			return false;		
		}
		
		public T next() {
			
			return get(index - 1);
		}
		
		public void remove() {
		}
	}
}
