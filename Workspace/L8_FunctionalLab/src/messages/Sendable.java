package messages;

/*******************************************************
 * <p>	This is a functional interface. Its abstract 
 * 		method manages a passed message.
 * *****************************************************/
public interface Sendable {

	public void message(Message m, String s);
}
