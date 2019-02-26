package iteration;

/*******************************************************************
 * <p> This class demonstrates a bubble sort algorithm.
 *******************************************************************/
public class BubbleSort {

	/*********************************************************
	 *  sorts array using the bubble sort algorithm
	 *  @param data array of integers.
	 *********************************************************/
	public static void bubbleSort(int[ ] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length - i - 1; j ++) {
				if (data[j] > data[j + 1]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}
	}

	/***************************************************************
	 *  prints contents of data.
	 ***************************************************************/
	public static void print(int[] data) {
		
		for(int i = 0; i < data.length; i++) {
			System.out.print("[" + i + "]");
		}
		System.out.println();
		
		for(int item : data) {
			System.out.print(" " + item + " ");
		}
		System.out.println();
		System.out.println();
	}

	/******************************************************
	 *  runs the program. Tests a data of numbers
	 ******************************************************/
	public static void main(String[] args) {
		int[] data = {2, 9, 5, 4, 8, 1};
		print(data);
	    bubbleSort(data);
		print(data);

	}

}
