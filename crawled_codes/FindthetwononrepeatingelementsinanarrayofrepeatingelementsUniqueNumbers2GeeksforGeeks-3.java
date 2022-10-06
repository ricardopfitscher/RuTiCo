//https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
//O(n log n)
/*package whatever //do not write package name here */
//Java program to find 2 non repeating elements
//in array that has pairs of numbers

import java.util.LinkedHashSet;
import java.util.Iterator;
import java.io.*;

class GFG {

	//Method to print the 2 non repeating elements in an array
	public static void print2SingleNumbers(int[] nums){
	
		// Create a Map Set to store the numbers
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
	
		int n = nums.length;
	
		/*Iterate through the array and check if each
		element is present or not in the set. If the
		element is present, remove it from the array
		otherwise add it to the set*/
	
		for(int i = 0; i<n; i++){
			if(set.contains(nums[i]))
				set.remove(nums[i]);
			else
				set.add(nums[i]);
		}
		
		//Iterator is used to traverse through the set
		Iterator<Integer> i = set.iterator();
	
		/*Since there will only be 2 non-repeating elements
		we can directly print them*/
		System.out.println("The 2 non repeating numbers are : " + i.next() + " " + i.next());
	}
	//Driver code
	public static void main (String[] args) {
		int[] nums = new int[]{2, 3, 7, 9, 11, 2, 3, 11 };
		print2SingleNumbers(nums);
	}
	//This code contributed by Satya Anvesh R
}
