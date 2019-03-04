/**
 * 
 */
package lists;

/**
 * @author E
 *
 * List outlines the expected behavior of a generic list.
 */
public interface List<T> {
	public void add(T value);
	public void add(int index, T value);
	public int indexOf(T Value);
	public void remove(int index);
	public int size();
	public String toString();
}
