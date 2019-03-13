package links;

/*******************************************************************
 * 	Used to store a list of linked objects that store integers.
 *******************************************************************/
public class IntLinkedList {

	/****************************************************
	 * 	declaration for underlying data structure 
	 ****************************************************/
	
	private Node front;		// reference to the first value in the list
	
	/********************************
	 * 	constructs an empty list
	 ********************************/
	public IntLinkedList() {
		this(null);
	}
	
	/***********************************************
	 * 	constructs a list with the first item
	 ***********************************************/
	public IntLinkedList(Node front) {
		this.front = front;
	}
	
	/****************************************************
	 * 	appends the given value to the end of the list 
	 ****************************************************/
	public void add(int value) {
		if(front == null)
			front = new Node(value);
		else {
			Node current = front;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new Node(value);
		}
	}
	
	/************************************************************
	 * 	inserts the given value at the given index of the list 
	 ************************************************************/
	public void add(int index, int value) {
		if(index == 0)
			front = new Node(value, front);
		else {
			Node current = nodeAt(index - 1);
			current.next = new Node(value, current.next);
		}
	}
	
	/*************************************************
	 *  returns the value at the given index 
	 *************************************************/
	public int get(int index) {
		return nodeAt(index).data;
	}
	
	/******************************************************
	 * 	returns the position of the first occurrence of  
	 * 	the given value (-1 if not found)
	 ******************************************************/
	public int indexOf(int value) {
		int index = 0;
		Node current = front;
		while(current.next != null) {
			if (current.data == value) {
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
	private Node nodeAt(int index) {
		Node current  = front;
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
			Node current = nodeAt(index - 1);
			current.next = current.next.next;
		}
	}
	
	/**************************************************************
	 * 	returns the current number of elements in the list 
	 **************************************************************/
	public int size() {
		int count = 0;
		Node current  = front;
		while(current != null) {
			current = current.next;
			count++;
		}
		return count;
	}
	
	/***************************************************************
	 * 	returns comma separated, bracketed version of list 
	 ***************************************************************/
	public String toString() {
		if(front == null) {
			return "[ ]";
		}else {
			String result = "[" + front.data;
			Node current = front.next;
			while(current != null) {
				result  += ", " + current.data;
				current = current.next;
			}
			result += " ]";
			return result;
		}
	}
	
}
