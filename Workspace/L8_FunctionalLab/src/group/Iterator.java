package group;

/************************************************************
 * <p>	Interface used to iterate over a list of objects.
 * **********************************************************/
public interface Iterator<T> {
	public boolean 	hasNext();
	public T 	 	next();
	public void 	remove();
}
