package construct;

public class Construction3Client {

	/********************************************************
	 *  prints without a iterative loop line by line.
	 * ******************************************************/
	public static void print(Node front) {
		System.out.println();
		System.out.print(front.data +" ");
		System.out.print(front.next.data +" ");
		System.out.print(front.next.next.data + " ");
		System.out.print(front.next.next.next.data + " ");
		System.out.print(front.next.next.next.next.data + " ");
	}
	
	/********************************************************
	 *  uses a while loop to print out data structure.
	 * ******************************************************/
	public static void printWhile(Node front) {
		//update
	}
	
	/********************************************************
	 *  uses a for loop to print out data structure.
	 * ******************************************************/
	public static void printFor(Node front) {
		//update
	}
	
	/********************************************************
	 *  runs the program.
	 * ******************************************************/
	public static void main(String[] args) {
		Node front = new Node();
		print(front);
		printWhile(front);
		printFor(front);
	}

}
