/********************************************************************
 * Description: Node class is used for storing a single node of a 
 * 				Integer Linked Data Structure.
 ******************************************************************** */
package construct;

public class Node {

	/*****************************************
	 * State: data fields
	 * 		  specifies data structure
	 *****************************************/
	public int  data;			//data stored in the current node
	public Node next;			//link to next node in linked structure
	
	/********************************************************************
	 * 	constructs a node with data = 0, link = null
	 ******************************************************************** */
	public Node() {
		this(0, null);
	}
	
	/********************************************************************
	 * 	constructs a node with given data , link = null
	 ********************************************************************/
	public Node(int data) {
		this(data, null);
	}
	
	/********************************************************************
	 * constructs a node with given data of type int 
	 ********************************************************************/
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
}
