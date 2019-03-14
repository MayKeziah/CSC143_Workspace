package rectangles;

import group.ArrayList;
import group.Comparator;
import group.Comparable;

public class RectangleClient {

	/*****************************************************************
	 *  sorts list using bubble sort algorithm.
	 * 	@param list array of values.
	 *	@param key comparator for sorting.
	 *****************************************************************/
	public static <T> void bubbleSort(ArrayList<T> list, Comparator<T> key) {
	}
	
	/**********************************************************
	 *  returns an index for which a string is found in list.
	 *  @param list array of values.
	 *  @param key  Rectangle object to find
	 *  @return index of value in list
	 * ********************************************************/
	public static int indexOf(ArrayList<Rectangle> list, Rectangle key) {
		return -1;
	}
	
	/*********************************************************
	 *   sorts array using the insertion sort algorithm
	 *   @param list array of values.
	 *********************************************************/
	public static <T extends Comparable<T>> 
	void insertionSort(ArrayList<T> list) {
	}
	
	/***********************************
	 *  runs program.
	 *  @param args instructions.
	 * *********************************/
	public static void main(String[] args) {
		
		ArrayList<Rectangle> list = new ArrayList<Rectangle>();
		list.add(new Rectangle(1, 8));
		list.add(new Rectangle(7, 9));
		list.add(new Rectangle(5, 3));
		list.add(new Rectangle(2, 5));
		list.add(new Rectangle(6, 2));
		list.add(new Rectangle(3, 7));
		list.add(new Rectangle(4, 9));
		list.add(new Rectangle(8, 6));

		System.out.println("------- dimensions --------");
		//call the bubble sort method to sort by dimensions.
		// Note: You can only use method references.
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) );
		}
		
		System.out.println();
		System.out.println("------- perimeters --------");
		//call the bubble sort method to sort by perimeters.
		// Note: You can only use method references.
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) );
			System.out.println("\t perim: " + list.get(i).perimeter());
		}
		
		System.out.println();
		System.out.println("------- natural ordering --------");
		insertionSort(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			System.out.println("\t area: " + list.get(i).perimeter());
		}
	}

}
