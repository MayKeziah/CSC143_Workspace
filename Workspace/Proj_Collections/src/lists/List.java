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
	
	public void		add(T value);
	public void		add(int index, T value);
	public T 		get(int index);
	public int 		indexOf(T Value);
	public boolean 	isEmpty();
//	public Iterator<T> iterator();
	public void 	remove(int index);
	public void 	set(int index, T value);
	public int 		size();
}
