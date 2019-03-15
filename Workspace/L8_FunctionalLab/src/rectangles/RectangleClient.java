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
		for (int i = 1; i < list.size(); i++) {
			for (int j = 0; j < list.size() - i; j ++) {
				
				if (key.compare(list.get(j), list.get(j + 1)) > 0) {
					T temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
	}
	
	/**********************************************************
	 *  returns an index for which a string is found in list.
	 *  @param list array of values.
	 *  @param key  Rectangle object to find
	 *  @return index of value in list
	 * ********************************************************/
	public static <T> int indexOf(ArrayList<Rectangle> list, Rectangle key) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	/*********************************************************
	 *   sorts array using the insertion sort algorithm
	 *   @param list array of values.
	 *********************************************************/
	public static <T extends Comparable<T>> 
	void insertionSort(ArrayList<T> list) {
		//For all unsorted indecies...
		for (int i = 1; i < list.size(); i++) {
			int j = i - 1;
			T elt = list.get(i);
			
			//... while the element is less than the next element in the sorted list, shift the list right one position
			while((j >= 0) && list.get(j).compareTo(elt) > 0) {
				list.set(j + 1, list.get(j));
				j--;
			}
			
			//Insert the current element into the appropriate part of the list.
			list.set(j + 1, elt);
		}		
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
		bubbleSort(list, Rectangle::compareDimensions);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) );
		}
		
		System.out.println();
		System.out.println("------- perimeters --------");
		//call the bubble sort method to sort by perimeters.
		// Note: You can only use method references.
		bubbleSort(list, Rectangle::comparePerimeters);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) );
			System.out.println("\t perim: " + list.get(i).perimeter());
		}
		
		System.out.println();
		System.out.println("------- natural ordering --------");
		insertionSort(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			System.out.println("\t area: " + list.get(i).area());
		}
	}

}
