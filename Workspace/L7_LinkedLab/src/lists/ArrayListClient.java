/**
 * 
 */
package lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author E
 *
 */
public class ArrayListClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.add(8);
		testList.add(9);
		System.out.println(testList);

		System.out.println(average(testList));

		System.out.println(even(testList));
		
		revise(testList);
		System.out.println(testList);
		
		removal(testList);
		System.out.println(testList);

		reverse(testList);
		System.out.println(testList);
	}
	
	/**
	 * Calculates the average of the integers stored in the list
	 * 
	 * @param list the list to traverse
	 * @return the average of the integers in the list
	 */
	public static double average(List<Integer> list) {
		Integer sum = new Integer(0);
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum * 1.0 / list.size();
	}
	
	/**
	 * Returns the even values stored in the list respectively
	 * 
	 * @param list the list to traverse
	 * @return a list of the even numbers taken from the list
	 */
	public static List<Integer> even(List<Integer> list){
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++) {
			if((list.get(i) % 2) == 0) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}
	
	/**
	 * Removes all elements equal to 3
	 * 
	 * @param list the list to edit
	 */
	public static void removal(List<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == 3) {
				list.remove(i);
			}
		}
	}
	
	/**
	 * Reverses the order of the elements in the list
	 * 
	 * @param list the list to reverse
	 */
	public static void reverse(List<Integer> list) {
		Integer x;
		for(int i = 0; i < list.size(); i++) {
			x = list.get(0);
			list.remove(0);
			list.add(list.size() - i, x);
		}
	}

	/**
	 * Moves elements of an odd index value to the end of the list, replacing them with a 3
	 * 
	 * @param list the list to revise
	 */
	public static void revise(List<Integer> list) {
		Integer x;
		int size = list.size();
		for (int i = 1; i < size; i += 2) {
			x = list.get(i);
			list.set(i, 3);
			list.add(x);
		}
	}

}
