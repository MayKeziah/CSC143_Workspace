/**
 * 
 */
package algorithms;

/**
 * @author E
 *
 */
public class AlgorithmClient {

	/**
	 * @param args, not used
	 */
	public static void main(String[] args) {
		/**
		 * @test for AlgorithmClient.print(int[])
		 */
		System.out.println("Test for print({1, 2, 4, 6, 9})");
		int[] l1 = {1, 2, 4, 6, 9};
		print(l1);
		System.out.println("_______________________________________________________________");
		
		/**
		 * @test for AlgorithmClient.getKeyCount(int[], int)
		 */
		System.out.print(
				"Testing getKeyCount:"
				+ "\n  Keys: 2, 4, 8"
				+ "\n  list: {1, 2, 8, 2, 7, 4, 2, 6, 8, 7, 8, 4, 2, 4, 2, 4, 9}"
				+ "\n  Output: ");
		int[] l2 = {1, 2, 8, 2, 7, 4, 2, 6, 8, 7, 8, 4, 2, 4, 2, 4, 9};
		int[] keys1 = {2, 4, 8};
		for (int elt:keys1) {
			System.out.print(getKeyCount(l2, elt) + " ");
		}
		System.out.println("\n_______________________________________________________________");

		
		/**
		 * @test for AlgorithmClient.indexOf(int[], int)
		 */
		System.out.print(
				"Testing indexOf:"
				+ "\n  Keys: 2, 7, 8"
				+ "\n  list: {1, 2, 4, 6, 7, 9}"
				+ "\n  Output: ");
		int[] l3 = {1, 2, 4, 6, 7, 9};
		int[] keys2 = {2, 7, 8};
		for (int elt:keys2) {
			System.out.print(indexOf(l3, elt) + " ");
		}
		System.out.println("\n_______________________________________________________________");

		
		/**
		 * @test for AlgorithmClient.shiftLeft(int[])
		 */
		System.out.print(
				"Testing shiftLeft:"
				+ "\n  list: {2, 4, 5, 7, 8, 9}"
				+ "\n  Output: ");
		int[] l4 = {2, 4, 5, 7, 8, 9};
		shiftLeft(l4);
		print(l4);
		System.out.println("\n_______________________________________________________________");
		
		/**
		 * @test for AlgorithmClient.shiftRight(int[])
		 */
		System.out.print(
				"Testing shiftRight:"
				+ "\n  list: {2, 4, 5, 7, 8, 9}"
				+ "\n  Output: ");
		int[] l5 = {2, 4, 5, 7, 8, 9};
		shiftRight(l5);
		print(l5);
		System.out.println("\n_______________________________________________________________");
		
		/**
		 * @test for AlgorithmClient.insert(int[])
		 */
		System.out.print(
				"Testing insert:"
				+ "\n  list: {1, 2, 4, 5, 7, 8, 9}"
				+ "\n  Output: ");
		int[] l6 = {1, 2, 4, 5, 7, 8, 9};
		insert(l6);
		print(l6);
		System.out.println("\n_______________________________________________________________");
		
		/**
		 * @test for AlgorithmClient.selectionSort(int[])
		 */
		System.out.print(
				"Testing selectionSort:"
				+ "\n  list: {2, 9, 5, 4, 8, 1, 6}"
				+ "\n  Output: ");
		int[] l7 = {2, 9, 5, 4, 8, 1, 6};
		selectionSort(l7);
		print(l7);
		System.out.println("\n_______________________________________________________________");

		/**
		 * @test for AlgorithmClient.descendingSort(int[])
		 */
		System.out.print(
				"Testing descendingSort:"
				+ "\n  list: {2, 9, 5, 4, 8, 1, 6}"
				+ "\n  Output: ");
		int[] l8 = {2, 9, 5, 4, 8, 1, 6};
		descendingSort(l8);
		print(l8);
		System.out.println("\n_______________________________________________________________");
	}
	
	/**
	 * print: prints the contents of an integer list stored in an array to the console.
	 * 
	 * @param list the list to print to the console
	 */
	public static void print(int[] list) {
		int len = list.length;
		String output = "[";
		for(int i = 0; i < len - 1; i++) {
			output += list[i] + ", ";
		}
		output += list[len-1] + "]";
		System.out.println(output);
	}
	
	/**
	 * getKeyCount: counts how many times a particular value appears in an integer list.
	 * 
	 * @param list the list to transverse searching for occurrences of the key
	 * @param key the value to search for in the list
	 * @return the number of occurrences of the given value stored in the given array.
	 */
	public static int getKeyCount(int[] list, int key) {
		int count = 0;
		for (int elt:list){
			if(elt == key) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * indexof: returns the index of the first occurrance of a value in an integer list. If the value is not found, -1 is returned.
	 * 
	 * @param list the list to search
	 * @param key the value to locate in the list
	 * @return the index location of the given value in the given array. -1 if the value is not present in the array.
	 */
	public static int indexOf(int[] list, int key) {
		for(int i = 0; i < list.length; i++) {
			if(list[i] == key) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * shiftLeft: Shifts the contents of an integer list to the left by one position, moving the first element to the last position.
	 * 
	 * @param list the list to edit
	 * */
	public static void shiftLeft(int[] list) {
		int firstElt = list[0];
		int len = list.length - 1;
		for(int i = 1; i <= len; i++) {
			list[i-1] = list[i];
		}
		list[len] = firstElt;
	}

	/**
	 * shiftRight: Shifts the contents of an integer list to the right by one position, moving the last element to the first position.
	 * 
	 * @param list the list to edit
	 * */
	public static void shiftRight(int[] list) {
		int len = list.length - 1;
		int lastElt = list[len];
		for(int i = len; i > 0; i--) {
			list[i] = list[i-1];
		}
		list[0] = lastElt;
	}
	
	/**
	 * insert: Shifts the contents of the last half of an integer list to the right by one position, moving the last element to the middle position.
	 * 
	 * @param list the list to edit
	 * */
	public static void insert(int[] list) {
		int len = list.length;
		int lastElt = list[len - 1];
		for (int i = len - 1; i > len / 2; i--) {
			list[i] = list[i - 1];
		}
		list[len/2] = lastElt;
	}
	
	/**
	 * selectionSort: Sorts an array of integers in ascending order.
	 * 
	 * @param list the list to sort
	 * */
	public static void selectionSort(int[] list) {
		int len = list.length;
		for(int i = 0; i < len; i++) {
			swap(i, findMin(list, i, len), list);
		}
	}
	
	/**
	 * swap: swaps the location of two elements in an integer array.
	 * 
	 * @param index1 the first index to swap
	 * @param index2 the second index to swap
	 * @param list the list to edit
	 * */
	public static void swap(int index1, int index2, int[] list) {
		int temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}
	
	/**
	 * findMin: finds the smallest element in a given range of an integer array.
	 * 
	 * @param list the list to transverse
	 * @param startIndex the beginning of the range inclusive
	 * @param endIndex the end of the range exclusive
	 * */
	public static int findMin(int[] list, int startIndex, int endIndex) {
		int currentMin = list[startIndex];
		int minIndex = startIndex;
		for( int i = startIndex; i < endIndex; i++) {
			if(list[i] <= currentMin) {
				currentMin = list[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	/**
	 * findMin: finds the largest element in a given range of an integer array.
	 * 
	 * @param list the list to transverse
	 * @param startIndex the beginning of the range inclusive
	 * @param endIndex the end of the range exclusive
	 * */
	public static int findMax(int[] list, int startIndex, int endIndex) {
		int currentMax = list[startIndex];
		int maxIndex = startIndex;
		for(int i = startIndex; i < endIndex; i++) {
			if(list[i] >= currentMax) {
				currentMax = list[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	/**
	 * descendingSort: Sorts an array of integers in descending order.
	 * 
	 * @param list the list to sort
	 * */
	public static void descendingSort(int[] list) {
		int len = list.length;
		for(int i = 0; i < len; i++) {
			swap(i, findMax(list, i, len), list);
		}
	}
}

