/**
 * 
 */
package utility;

import college.Student;
import lists.ArrayList;

/**
 * @author E
 *
 */
public class Query {
	public static <T extends Comparable<T>> int binarySearch(ArrayList<T> list, T key) {
		int low = 0;
		int high = list.size() - 1;
		int mid = (high + low)/2;
		while(low <= high) {
			if(list.get(mid).equals(key)) {
				return mid;
			}if (list.get(mid).compareTo(key) > 0) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
			mid = (high + low)/2;
		}
		return -1;
	}
	
	public static <T extends Comparable<T>> void bubbleSort(ArrayList<T> list, Comparator<T> key) {
		for (int i = 1; i < list.size(); i++) {
			for (int j = 0; j < list.size() - i; j ++) {
				
				if (list.get(j).compareTo(list.get(j + 1)) > 0) {
					T temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
	}
	
	public static int indexOf(ArrayList<Student> list, String key) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	/***************************************************************
	 * 	@return the pivot index.
	 * 	@param list an ArrayList of integers.
	 * 	@param left the low index.
	 * 	@param right the high index.
	 ***************************************************************/
	public static <T extends Comparable<T>> int partition(ArrayList<T> list, int left, int right) {
		T p = list.get((left + right)/2);
		boolean finished = false;
		
		//Quick Sort the sub-array until right and left are equal or have crossed.
		while(!finished) {
			
			//If the left value is less than the pivot value, check the next value.
			while(list.get(left).compareTo(p) < 0) {
				left++;
			} 
			//if the right value is greater than the pivot value, check the next value.
			while(list.get(right).compareTo(p) > 0) {
				right--;
			}
			//If right and left are equal or have crossed, your sort is complete
			if (right <= left) {
				finished = true;
			}
			//Once you have an out of place right and left value, swap them. 
			else {
				T temp = list.get(left);
				list.set(left, list.get(left));
				list.set(left, temp);
				left++;
				right--;
			}

		}
		//The location of the right value becomes the last index of the next partition.
		return right;
	}
	
	/*****************************************************************
	 *  sorts data using quick sort algorithm using recursion.
	 * 	@param list an ArrayList of integers.
	 *	@param left the low index.
	 * 	@param right the high index.  
	 *****************************************************************/
	public static <T extends Comparable<T>> void quickSort(ArrayList<T> list, int left, int right) {
		if (left >= right) { //Do nothing
			return;
		}
		int last;			 // last item in left partition
		
		/*****************************************************************
		 * partition: index
		 *            partition the data within the array. Value returned
		 *        	  from partitioning is the location of the last item 
		 *            in left partition.
		 * ***************************************************************/
		last = partition(list, left, right);
		
		/**********************************************************
		 * recursion: sort
		 *        	  recursively sort left partition (left to last) 
		 *            and right partition (last + 1 to right).
		 * ********************************************************/
		quickSort(list, left, last);
		quickSort(list, last + 1, right);
	}
}
