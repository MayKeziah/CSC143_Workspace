package generic;

public class Generic<T> implements GenericFace{
	
	private T data;
	
	/**
	 * Constructor: default, initializes the Generic Object to null
	 * */
	public Generic(){
		this(null);
	}
	
	/**
	 * Constructor (T data):
	 * @param data the data to store (of non-primitive type)
	 * */
	public Generic(T data){
		set(data);
	}
	
	
	/**
	 * Mutator set(T data):
	 * @param data the data to store (of non-primitive type)
	 * */
	public void set(T data) {
		this.data = data;
	}
	
	/**
	 * Accessor get():
	 * @return data the data stored
	 * */
	public T get() {
		return data;
	}
	
	/**
	 * @override java.lang.Object.hashCode
	 * Method hashCode():
	 * @return an integer representing the hash code of the object plus 200 mil.
	 * */
	public int hashCode() {
		return data.hashCode() + 200000000;
	}

	/**
	 * Accessor toString():
	 * @return a String representation of the data stored
	 * */
	public String toString() {
		return data.toString();
	}
	
}
