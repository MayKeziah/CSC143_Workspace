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
		
		return aNode;
	}
	
	/*********************************************************
	 *  using the one argument and two argument constructors
	 *  in Node class.
	 * *******************************************************/
	public static Node buildB() {
		System.out.println();
		System.out.println("--------build B -------");
		
		
		return new Node();
	}
	
	/*********************************************************
	 *  using the one argument and two argument constructors
	 *  in Node class.
	 * *******************************************************/
	public static Node buildC() {
		System.out.println();
		System.out.println("-------- build C -------");
		return new Node();
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
