package messages;

public class Message {

	private String msg;
	
	/**********************************************
	 * 	passes string parameter to constructor.
	 **********************************************/
	public Message(String msg) {
		System.out.print("Message Constructor..." + msg);
		this.msg = msg;
	}
		
	/****************************************************
	 * 	static method that creates a new message
	 ****************************************************/
	public static Message broadcast(String msg) {
		System.out.println("Creating a new broadcast...THIS IS NEW!!! ");
		return new Message(msg.toLowerCase());
	}
	
	/****************************************************
	 * 	static method that prints message as a string.
	 * **************************************************/
	public static void connect(Message m, String msg) {
		System.out.println("You are now connected....  ");
		System.out.print( m + " ...connects with..." );
		System.out.println( msg.toUpperCase() + "\n ...disconnect. " );
		
	}
		
	/****************************************************
	 * 	static method that prints text message.
	 ****************************************************/
	public static String send(String text) {
		System.out.print("Welcome to the Texting Experience.  ");
		System.out.println("Enjoy!.");
		return text;
	}
	
	/****************************************************
	 * 	replaces definition of toString method of
	 *  Object class.
	 ****************************************************/
	public String toString() {
		return msg;
	}
	
}
