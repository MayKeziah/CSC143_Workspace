package iteration;
/*******************************************************************
 * <p>This class demonstrates a selection sort algorithm.
 *******************************************************************/
public class SelectionSort {

	/******************************************************
	 *  runs the program. Tests an array of integers.
	 ******************************************************/
	public static void main(String[] args) {
		int[] data = {2, 9, 5, 4, 8, 1, 6};
		print(data);
		selectionSort(data);
		print(data);
	}
	
	/***********************************************
	 *  prints contents of array.
	 *  @param data array of integers.
	 ***********************************************/
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
	
	/***************************************************************
	 *  sorts an array using selection sort algorithm.
	 *  @param data array of integers.
	 ***************************************************************/
	public static void selectionSort(int[] data) {
		int minIdx;
		int temp;
		
		//For each index in the array except the end value...
		for (int i = 0; i < data.length - 1; i ++) {
			minIdx = i;
			
			//Check to see if it is the min value.
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[minIdx]) {
					minIdx = j;
					
				}
			}
			
			//If it is not the min value, swap it with the min value.
			if(minIdx != i) {
				temp = data[i];
				data[i] = data[minIdx];
				data[minIdx] = temp;
			}

		}
	}
	
}
