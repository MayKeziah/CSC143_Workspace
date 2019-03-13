package construct;

public class Construction1Client {

	/*********************************
	 *  runs the program.
	 * *******************************/
	public static void main(String[] args) {
		
		Node front = new Node();
		front.data = 1;
		front.next = new Node();
		front.next.data = 2;
		front.next.next = new Node();
		front.next.next.data = 4;
		front.next.next.next = new Node();
		front.next.next.next.data = 5;
		front.next.next.next.next = new Node();
		front.next.next.next.next.data = 9;
		
		System.out.println();
		System.out.print(front.data +" ");
		System.out.print(front.next.data +" ");
		System.out.print(front.next.next.data + " ");
		System.out.print(front.next.next.next.data + " ");
		System.out.print(front.next.next.next.next.data + " ");

	}

}
