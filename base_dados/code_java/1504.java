package com.interview.algorithms.array;

/**
 * Given a sorted array and a value x, the ceiling of x is the smallest element
 * in array greater than or equal to x, and the floor is the greatest element
 * smaller than or equal to x. Assume than the array is sorted in non-decreasing
 * order. Write efficient functions to find floor and ceiling of x.
 * 
 * For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
 *  For x = 0:floor doesn't exist in array, ceil = 1
 *  For x = 1: floor = 1, ceil = 1 
 *  For x = 5: floor = 2, ceil = 8
 *   For x = 20: floor= 19, ceil doesn't exist in array
 *
 *
 * @author ajitkoti
 */
public class FloorAndCeilingInASortedArray {

	/**
	 * Instead of using linear search, binary search is used here to find out
	 * the index. Binary search reduces time complexity to O(Logn).
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @param x
	 * @return
	 */
	private static int ceilSearch(int arr[], int low, int high, int x) {
		int mid;

		/*
		 * If x is smaller than or equal to the first element, then return the
		 * first element
		 */
		if (x <= arr[low])
			return low;

		/* If x is greater than the last element, then return -1 */
		if (x > arr[high])
			return -1;

		/* get the index of middle element of arr[low..high] */
		mid = (low + high) / 2; /* low + (high - low)/2 */

		/* If x is same as middle element, then return mid */
		if (arr[mid] == x)
			return mid;

		/*
		 * If x is greater than arr[mid], then either arr[mid + 1] is ceiling of
		 * x or ceiling lies in arr[mid+1...high]
		 */
		else if (x > arr[mid]) {
			if (mid + 1 <= high && x <= arr[mid + 1])
				return mid + 1;
			else
				return ceilSearch(arr, mid + 1, high, x);
		}

		/*
		 * If x is smaller than arr[mid], then either arr[mid] is ceiling of x
		 * or ceiling lies in arr[mid-1...high]
		 */
		else {
			if (mid - 1 >= low && x > arr[mid - 1])
				return mid;
			else
				return ceilSearch(arr, low, mid - 1, x);
		}
	}

	/* Driver program to check above functions */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
		int n = arr.length;
		int x = 11;
		int index = ceilSearch(arr, 0, n - 1, x);
		if (index == -1)
			System.out.println("Ceiling of doesn't exist in array " + x);
		else
			System.out.println("ceiling of" + x + " is " + arr[index]);

	}

}