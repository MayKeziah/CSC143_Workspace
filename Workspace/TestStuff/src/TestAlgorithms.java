import java.util.Arrays;

public class TestAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void Advance(int minutesForward){
	    int tempMins = minute + (minutesForward / 60);
	    int tempHrs = hour + (minutesForward % 60);
	    if (tempMins > 59){
	        minute = tempMins - 60;
	        
	    }
	    else{
	        minute = tempMins;
	    }
	    if (tempHrs > 12){
	    	hour = tempHrs % 12;
	    	if ( ((tempHrs / 12) % 2 == 0) ) {}
	    	else if (amPm.equals("AM")) {
	    		amPm = "PM";
	    	}
	    	else {
	    		amPm = "AM";
	    	}
	    }
	}

	public boolean contains(int[] a1, int[] a2) {
		boolean toReturn = false;
		boolean[] test = new boolean[a2.length];
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
