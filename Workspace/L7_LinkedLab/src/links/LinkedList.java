/**
 * 
 */
package links;

/**
 * @author E
 *
 */

/*******************************************************************
 * 	Used to store a list of linked objects that store Generic objects.
 *******************************************************************/
public class LinkedList<E> implements List<E> {

	/****************************************************
	 * 	declaration for underlying data structure 
	 ****************************************************/
	
	private Node<E> front;		// reference to the first value in the list
	private int size;
	
	/********************************
	 * 	constructs an empty list
	 ********************************/
	public LinkedList() {
		this(null);
		size = 0;
	}
	
	/***********************************************
	 * 	constructs a list with the first item
	 ***********************************************/
	public LinkedList(Node<E> front) {
		this.front = front;
		size = 1;
	}
	
	/****************************************************
	 * 	appends the given value to the end of the list 
	 ****************************************************/
	public void add(E value) {
		if(front == null)
			front = new Node<E>(value);
		else {
			Node<E> current = front;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new Node<E>(value);
		}
		size++;
	}
	
	/************************************************************
	 * 	inserts the given value at the given index of the list 
	 ************************************************************/
	public void add(int index, E value) {
		if(index == 0)
			front = new Node<E>(value, front);
		else {
			Node<E> current = nodeAt(index - 1);
			current.next = new Node<E>(value, current.next);
		}
		size++;
	}
	
	/*************************************************
	 *  returns the value at the given index 
	 *************************************************/
	public E get(int index) {
		return (E) nodeAt(index).data;
	}
	
	/******************************************************
	 * 	returns the position of the first occurrence of  
	 * 	the given value (-1 if not found)
	 ******************************************************/
	public int indexOf(E value) {
		int index = 0;
		Node<E> current = front;
		while(current.next != null) {
			if (current.data.equals(value)) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}
	
	/**************************************************************
	 * 	returns reference to the nodeAt at the given index 
	 **************************************************************/
	private Node<E> nodeAt(int index) {
		Node<E> current  = front;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}
	
	/*************************************************************
	 * 	removes value at the given index 
	 *************************************************************/
	public void remove(int index) {
		if(index == 0) {
			front = front.next;
		}else {
			Node<E> current = nodeAt(index - 1);
			current.next = current.next.next;
		}
		size--;
	}
	
	/**************************************************************
	 * 	returns the current number of elements in the list 
	 **************************************************************/
	public int size() {
//		int count = 0;
//		Node<E> current  = front;
//		while(current != null) {
//			current = current.next;
//			count++;
//		}
//		return count;
		return size;
	}
	
	/***************************************************************
	 * 	returns comma separated, bracketed version of list 
	 ***************************************************************/
	public String toString() {
		if(front == null) {
			return "[ ]";
		}else {
			String result = "[" + front.data;
			Node<E> current = front.next;
			while(current != null) {
				result  += ", " + current.data;
				current = current.next;
			}
			result += " ]";
			return result;
		}
	}
	

	@Override
	public boolean isEmpty() {
		return front.equals(null);
	}

	@Override
	public void set(int index, E value) {
		nodeAt(index).data = value;
		
	}
	
	/*****************************************************
	 *  A class for storing a single node of a linked
	 *  data structure of integers.
	 *****************************************************/
	public static class Node<E> {

		/********************************************
		 * 	specifies underlying data structure
		 ********************************************/
		public E  data;			//data stored in the current node
		public Node<E> next;	//link to next node in list
		public Node<E> prev;	//link to previous node in list
		
		/***************************************************
		 * 	constructs a node with data = null, link = null
		 ***************************************************/
		public Node() {
			this(null, null);
		}
		
		/***************************************************
		 * 	constructs a node with given data , link = null
		 ***************************************************/
		public Node(E data) {
			this(data, null);
		}
		
		/**************************************************
		 * 	constructs a node with given data of generic type  
		 **************************************************/
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
		
	}
	
	/*****************************************************
	 *  A class for iterating through a linked
	 *  data structure of generic objects.
	 *****************************************************/
	public class LinkedIterator<E> implements Iterator<E> {

		/********************************************
		 * 	Tracks the status of the iterations
		 ********************************************/
		private Node<E> current;		//Tracks the current position
		private boolean ableToRemove;	//Can I remove the current Node?
		
		/***************************************************
		 * 	constructs an iterator with current set to
		 *  front.next and ableToRemove set to false.
		 ***************************************************/
		@SuppressWarnings("unchecked")
		public LinkedIterator(){
			current = (Node<E>) front.next;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

	
}

