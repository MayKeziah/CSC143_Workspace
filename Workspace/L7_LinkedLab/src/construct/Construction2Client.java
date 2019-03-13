package construct;

public class Construction2Client {
	
	/************************************************
	 * prints out linked structure.
	 * **********************************************/
	public static void show(Node node) {
		System.out.print(node.data +" ");
		System.out.print(node.next.data +" ");
		System.out.print(node.next.next.data + " ");
		System.out.print(node.next.next.next.data + " ");
		System.out.print(node.next.next.next.next.data + " ");
		System.out.println();
	}
	
	
	/******************************************************
	 *  using the no argument constructor in Node class.
	 * ****************************************************/
	public static Node buildA() {
		System.out.println();
		System.out.println("--------build A -------");
		Node aNode = new Node();
		aNode.data = 1;
		aNode.next = new Node();
		aNode.next.data = 3;
		aNode.next.next = new Node();
		aNode.next.next.data = 6;
		aNode.next.next.next = new Node();
		aNode.next.next.next.data = 8;
		aNode.next.next.next.next = new Node();
		aNode.next.next.next.next.data = 9;
		
		return aNode;
	}
	
	/*********************************************************
	 *  using the one argument and two argument constructors
	 *  in Node class.
	 * *******************************************************/
	public static Node buildB() {
		System.out.println();
		System.out.println("--------build B -------");
		Node aNode = new Node(2);
		aNode.next = new Node(3);
		aNode.next.next = new Node(6);
		aNode.next.next.next = new Node(7);
		aNode.next.next.next.next = new Node(9);
		
		return aNode;
	}
	
	/*********************************************************
	 *  using the one argument and two argument constructors
	 *  in Node class.
	 * *******************************************************/
	public static Node buildC() {
		System.out.println();
		System.out.println("-------- build C -------");
		Node aNode = new Node(3, new Node(5, new Node(6, new Node(8, new Node(9)))));

		return aNode;
	}
	
	/********************************************************
	 *  runs the program.
	 * ******************************************************/
	public static void main(String[] args) {
		
		show( buildA() );
		show( buildB() );
		show( buildC() );

	}

}
