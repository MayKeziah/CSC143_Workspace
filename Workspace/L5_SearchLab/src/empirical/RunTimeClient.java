package empirical;

import java.util.Random;
/****************************************************************************
 * <p>This class looks at the performance of algorithms used to find the
 *    range of numbers in an integer array. 
 ****************************************************************************/
public class RunTimeClient {

	/***************************************************************
	 *  creates a bit of tom foolery that attempts to generate
	 *  an illogical randomized data set.
	 *  @param numbers integer array
	 ***************************************************************/
	public static int[] dataSet(int n) {
		long startTime = System.currentTimeMillis();
		
		//just some tom foolery 
		Random random = new Random();	//generates a pseudo random number
		int[] data = new int[n];
		
		int qtr1 = data.length / 4;
		int qtr2 = qtr1 + data.length / 4;
		int qtr3 = qtr2 + data.length / 4;
		int qtr4 = qtr3 + data.length / 4;
		
		//begin: tom foolery 
		for (int i = 0; i < qtr1; i++) {
			data[i] =  random.nextInt() + 1;
		}
		
		for (int i = qtr1; i < qtr2; i++) {
			data[i] = random.nextInt() + 2;
		}
		
		for (int i = qtr2; i < qtr3; i++) {
			data[i] =  random.nextInt() - 1;
		}
		
		for (int i = qtr3; i < qtr4; i++) {
			data[i] =  random.nextInt() - 2;
		}
		
		long endTime   = System.currentTimeMillis();
		
		System.out.print("DataSet:  n = " + n + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
		return data;
	}
	
	/***************************************************************
	 *  computes the range of numbers in an array. The range is the 
	 *  difference between the lowest and highest numbers in an 
	 *  array.
	 *  @param numbers integer array
	 ***************************************************************/
	public static int range$1(int[] numbers) {
		int diff    = 0;
		int maxDiff = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				diff = Math.abs(numbers[j] - numbers[i]);
				
				if(maxDiff < diff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}
	
	/***************************************************************
	 *  computes the range of numbers in an array. The range is the 
	 *  difference between the lowest and highest numbers in an 
	 *  array.
	 *  @param numbers integer array
	 ***************************************************************/
	public static int range$2(int[] numbers) {
		int diff    = 0;
		int maxDiff = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j =  i + 1; j < numbers.length; j++) {
				diff = Math.abs(numbers[j] - numbers[i]);
				
				if(maxDiff < diff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}
	
	/***************************************************************
	 *  computes the range of numbers in an array. The range is the 
	 *  difference between the lowest and highest numbers in an 
	 *  array.
	 *  @param numbers integer array
	 ***************************************************************/
	public static int range$3(int[] numbers) {
		int max = numbers[0];
		int min = max;
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
				
			} else if(numbers[i]< min){
				min = numbers[i];
			}
		}
		return max - min;
	}
	
	/***************************************************************
	 *  approximates how long the method takes to run.
	 *  @param numbers integer array
	 ***************************************************************/
	public static void timeRange$1(int[] numbers) {
		long startTime = System.currentTimeMillis();
		range$1(numbers);
		long endTime   = System.currentTimeMillis();
		System.out.print("DataSet:  n = " + numbers.length + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}
	
	/***************************************************************
	 *  approximates how long the method takes to run.
	 *  @param numbers integer array
	 ***************************************************************/
	public static void timeRange$2(int[] numbers) {
		long startTime = System.currentTimeMillis();
		range$2(numbers);
		long endTime   = System.currentTimeMillis();
		System.out.print("DataSet:  n = " + numbers.length + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}
	
	
	/***************************************************************
	 *  approximates how long the method takes to run.
	 *  @param numbers integer array
	 ***************************************************************/
	public static void timeRange$3(int[] numbers) {
		long startTime = System.currentTimeMillis();
		range$3(numbers);
		long endTime   = System.currentTimeMillis();
		System.out.print("DataSet:  n = " + numbers.length + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}
	
	/******************************************************
	 *  runs the program. Tests a data set of integers.
	 ******************************************************/
	public static void main(String[] args) {
		
		System.out.println("Data Set - 1 to 8");
		int[] data1  = dataSet(2000);
		int[] data2  = dataSet(4000);
		int[] data3  = dataSet(8000);
		int[] data4  = dataSet(16000);
		int[] data5  = dataSet(32000);
		int[] data6  = dataSet(64000);
		int[] data7  = dataSet(128000);
		int[] data8  = dataSet(256000);
		
		System.out.println();
		System.out.println("Range 1 - Run Time Analysis");
		timeRange$1(data1);
		timeRange$1(data2);
		timeRange$1(data3);
		timeRange$1(data4);
		timeRange$1(data5);
		timeRange$1(data6);
		timeRange$1(data7);
		timeRange$1(data8);
		
		System.out.println();
		System.out.println("Range 2 - Run Time Analysis");
		timeRange$2(data1);
		timeRange$2(data2);
		timeRange$2(data3);
		timeRange$2(data4);
		timeRange$2(data5);
		timeRange$2(data6);
		timeRange$2(data7);
		timeRange$2(data8);
		
		System.out.println();
		System.out.println("Data Set - 9 to 18 for Range 3");
		
		int[] data9  = dataSet(512000);
		int[] data10 = dataSet(1024000);
		int[] data11 = dataSet(2048000);
		int[] data12 = dataSet(4096000);
		int[] data13 = dataSet(8192000);
		int[] data14 = dataSet(16384000);
		int[] data15 = dataSet(32768000);
		int[] data16 = dataSet(65536000);
		int[] data17 = dataSet(131072000);
		int[] data18 = dataSet(262144000);
		
		System.out.println();
		System.out.println("Range 3 - Run Time Analysis");
		timeRange$3(data1);
		timeRange$3(data2);
		timeRange$3(data3);
		timeRange$3(data4);
		timeRange$3(data5);
		timeRange$3(data6);
		timeRange$3(data7);
		timeRange$3(data8);
		timeRange$3(data9);
		timeRange$3(data10);
		timeRange$3(data11);
		timeRange$3(data12);
		timeRange$3(data13);
		timeRange$3(data14);
		timeRange$3(data15);
		timeRange$3(data16);
		timeRange$3(data17);
		timeRange$3(data18);
	}

}
