import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args){
		int[] data = {2, 9, 5, 4, 8, 1, 6};
		System.out.println(Arrays.toString(data));
		selectionSort(data);
		System.out.println(Arrays.toString(data));

	}
	public static void selectionSort(int[] data){
		//for each elt except the last one, check to see if it is the min
		selectionSort(data, 0, 1);

	}
	
	//for each elt except the last one, check to see if it is the min
	public static void selectionSort(int[] data, int min, int max){
		
	}
}
