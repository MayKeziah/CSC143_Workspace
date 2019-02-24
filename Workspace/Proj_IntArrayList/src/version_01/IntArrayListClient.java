/**
 * 
 */
package version_01;

/**
 * @author E
 *
 */
public class IntArrayListClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntArrayList testDefault = new IntArrayList();
		for (int i = 1; i < 11; i++) {
			testDefault.add(i);
		}
		System.out.println(testDefault);
		testDefault.remove(6);
		System.out.println(testDefault);
		

	}

}
