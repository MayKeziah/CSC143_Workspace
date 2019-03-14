package messages;

/*******************************************************
 * <p>	This is a functional interface. Its abstract 
 * 		method manages a passed message.
 * *****************************************************/
public interface Messageable {
	
	public Message getMessage(String msg);
}
