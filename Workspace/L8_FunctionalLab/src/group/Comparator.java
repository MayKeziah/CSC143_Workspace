package group;

/*********************************************************************
 * <p>	This is a functional interface. It has a method that returns 
 * 		a negative integer, 0 or positive integer to indicate the less 
 * 		than, equal to, or greater than relationship respectively.
 * *******************************************************************/
public interface Comparator<T> {

	public int compare(T first, T second);
}
