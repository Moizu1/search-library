package tests;

public class unittesting {
	public static int binarySearch(int[] arr, int target) {
	    int left = 0;
	    int right = arr.length - 1;

	    while (left <= right) {
	        int mid = left + (right - left) / 2;

	        if (arr[mid] == target) {
	            return mid; // element found
	        } 
	        else if (arr[mid] < target) {
	            left = mid + 1;
	        } 
	        else {
	            right = mid - 1;
	        }
	    }

	    return -1; // element not found
	}
	
	public static int linearSearch(int[] arr, int target) {
	    for (int i = 0; i < arr.length; i++) {
	        if (arr[i] == target) {
	            return i; // element found
	        }
	    }
	    return -1; // element not found
	}
	
	public static int jumpSearch(int[] arr, int target) {
	    int n = arr.length;
	    int step = (int) Math.sqrt(n);
	    int prev = 0;

	    // Finding the block where element may be present
	    while (arr[Math.min(step, n) - 1] < target) {
	        prev = step;
	        step += (int) Math.sqrt(n);
	        if (prev >= n) {
	            return -1;
	        }
	    }

	    // Linear search inside the block
	    while (arr[prev] < target) {
	        prev++;
	        if (prev == Math.min(step, n)) {
	            return -1;
	        }
	    }

	    if (arr[prev] == target) {
	        return prev;
	    }

	    return -1;
	}
	
}

