import java.util.Arrays;
import java.util.Scanner;

public class TestAlgorithms {

	public static void main(String[] args) {
		String test1 = "Hello you";
		String test2 = "uoy olleH";
		isReverse(test1, test2);
	}
	
	public static boolean isReverse(String s1, String s2){
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		System.out.println(reverse(s2));
	    return s1.equals(reverse(s2));
	}
	public static String reverse(String s1){
	    if ((s1 == null)||(s1.length() <= 1)) {
	           return s1;
	    }else{ 
	           return s1.charAt(s1.length()-1) + reverse(s1.substring(0,s1.length()-1)); 
	    } 
	}
	
	public static void wordLengths(Scanner file){
	    int[] tokensOfLength = new int[81];
	    int maxLength = 0;
	    String lines = "";
	    while(file.hasNextLine()){
	        lines += file.nextLine() + " ";
	    }
	    String[] words = lines.split(" ");
	    for (String elt: words){
	        int thisLen = elt.length();
	        if (thisLen > maxLength){
	            maxLength = thisLen;
	        }
	        tokensOfLength[thisLen]++;
	    }
	    for (int i = 1;  i < maxLength; i++){
	        int elt = tokensOfLength[i];
	        if (elt == 0){}
	        else{
	            String output = i + ": " + elt + "\t";
	            for(int j = 1; j <= elt; j++){
	                output += "*";
	            }
	            System.out.println(output);
	        }
	    }
	}
	
	public static int[] append(int[] list1, int[] list2){
	    int len1 = list1.length;
	    int len2 = list2.length;
	    int newLen = len1 + len2;
	    int[] newList = new int[newLen];
	    add(newList, list1, 0, len1);
	    add(newList, list2, len1, len2 );
	    return newList;
	}

	public static void add(int[] data, int[] addition, int fromIndex, int iterationsCap){
	    for (int i = fromIndex; i < iterationsCap + fromIndex; i++){
	        data[i] = addition[i - fromIndex];
	    }
	}
	
	public static int longestSortedSequence(int[] a){
	    int maxCounter = 0;
	    int currentCount = 1;
	    if (a.length == 0){
	        return maxCounter;
	    }
	    maxCounter++;
	    int testInt = a[0];
	    for (int i = 1; i < a.length; i++){
	        if (a[i] >= testInt){
	            currentCount++;
	        }
	        if(currentCount > maxCounter){
	            maxCounter = currentCount;
	        }
	        if (a[i] < testInt) {
	            currentCount = 1;
	        }
	        testInt = a[i];
	    }
	    return maxCounter;
	}
	
	public void enhancedForLoop() {
		int[] my = {1, 2, 3, 4};
		for (int x: my) {
			System.out.println(x);
		}
	}
//	public void Advance(int minutesForward){
//	    int tempMins = minute + (minutesForward / 60);
//	    int tempHrs = hour + (minutesForward % 60);
//	    if (tempMins > 59){
//	        minute = tempMins - 60;
//	        
//	    }
//	    else{
//	        minute = tempMins;
//	    }
//	    if (tempHrs > 12){
//	    	hour = tempHrs % 12;
//	    	if ( ((tempHrs / 12) % 2 == 0) ) {}
//	    	else if (amPm.equals("AM")) {
//	    		amPm = "PM";
//	    	}
//	    	else {
//	    		amPm = "AM";
//	    	}
//	    }
//	}

	public boolean contains(int[] a1, int[] a2) {
		boolean toReturn = false;
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] == a2[0]) {
				if (Arrays.equals(Arrays.copyOfRange(a1, i, i + a2.length), a2)) {
					toReturn = true;
					return toReturn;
				}
			}
		}
		return toReturn;
	}
	
	public int mode(int[] myList) {
		int length = myList.length;
		int currentValue = myList[0];
		int currentCount = 1;
		int highestCountValue = currentValue;
		int highestValueCount = 0;
		for (int i = 1; i < length; i++) {
			if (i == (length - 1)) {
				if (currentCount > highestValueCount) {
					highestValueCount = currentCount;
				}
			}
			if (myList[i] == currentValue) {
				currentCount++;
			}
			else {
				if(currentCount > highestValueCount) {
					highestValueCount = currentCount;
					highestCountValue = myList[i-1];
				}
				currentCount = 1;
				currentValue = myList[i];
			}
		}
		return highestCountValue;
	}

}
