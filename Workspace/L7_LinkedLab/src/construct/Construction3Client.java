package construct;

public class Construction3Client {

	/********************************************************
	 *  prints without a iterative loop line by line.
	 * ******************************************************/
	public static void print(Node front) {
		System.out.println("---------- print( ) ----------");
		System.out.print(front.data +" ");
		System.out.print(front.next.data +" ");
		System.out.print(front.next.next.data + " ");
		System.out.print(front.next.next.next.data + " ");
		System.out.println(front.next.next.next.next.data + " ");
	}
	
	/********************************************************
	 *  uses a while loop to print out data structure.
	 * ******************************************************/
	public static void printWhile(Node front) {
		System.out.println("-------- printWhile() --------");
		Node current = front;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	/********************************************************
	 *  uses a for loop to print out data structure.
	 * ******************************************************/
	public static void printFor(Node front) {
		System.out.println("--------- printFor() ---------");
		for(Node current = front; current != null; current = current.next) {
			System.out.print(current.data + " ");
		}
		System.out.println();
	}
	
	/********************************************************
	 *  runs the program.
	 * ******************************************************/
	public static void main(String[] args) {
		Node front = new Node(2, new Node(5, new Node(6, new Node(7, new Node(9)))));
		print(front);
		printWhile(front);
		printFor(front);
		System.out.println("---------- -------- ----------");

	}

}
