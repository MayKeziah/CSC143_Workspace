package messages;
/******************************************************************************
 * <p> Method Reference
 * <br>	Definition:  A reference to an existing method called by the lone
 * 					 method of the functional interface.
 * <br> Syntax: 	 Double colon operator (::) is used for method references.
 * <br>	Data Type:	 The data type of a method reference or lambda expression 
 * 					 is the functional interface type.
 * ***************************************************************************/

public class MessageClient {
	
	/*************************************************************
	 *	message method implements method in call.
	 *	@param msg Messageable Interface type
	 *************************************************************/
	public static void transmitA(Messageable msg) {
		System.out.println("Entering transmit - Messageable.");
		msg.getMessage("Messageable Interface Used...\n");
		System.out.println("Leaving transmit - Messageable.");
	}
	
	/*************************************************************
	 *	message method implements method in call.
	 *	@param msg Sendable Interface type
	 *************************************************************/
	public static void transmitB(Sendable msg) {
		System.out.println("Entering transmit - Sendable.");
		msg.message(new Message("transmiting. "), "Sendable Interface Used");
		System.out.println("Leaving transmit - Sendable.");
	}
	
	/*************************************************************
	 *	message method implements method in call.
	 *	@param msg Textable Interface type
	 *************************************************************/
	public static void transmitC(Textable msg) {
		System.out.println("Entering transmit - Textable.");
		System.out.println(msg.message("Textable Interface Used"));
		System.out.println("Leaving transmit - Textable.");
	}
	
	/*************************************************************
	 * 	runs program. Program starts here.
	 *************************************************************/
	public static void main(String[] args) {
		
		System.out.println("(1) Static Method Reference");
		//use a method reference to call the send method in Message class
		transmitC(Message::send); //doesn't care about the method name, just requires matching input and output
		
		System.out.println();
		System.out.println("(2)  String Reference");
		//use a method reference to call a string reference 
		transmitC(String::toUpperCase);
		
		System.out.println();
		System.out.println("(3)  Message Class Reference");
		//use a method reference to call the broadcast method in Message class
		transmitA(Message::broadcast);
		
		System.out.println();
		System.out.println("(4) Constructor Reference");
		//use a method reference to call the constructor of Message class
		transmitA(Message::new);
		
		System.out.println();
		System.out.println("(5)  Arbitrary Reference");
		//use a method reference to call the connect method in Message class
		transmitB(Message::connect);
	}
	
}