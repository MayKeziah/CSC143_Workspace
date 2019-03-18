import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a number:");
		int x = keyboard.nextInt();
		System.out.println("Enter a number:");
		int y = keyboard.nextInt();
		System.out.print(x + y);
	}

}
