//https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
//O(n log n)
// Java code to implement the approach
import java.util.*;

class GFG {

/* This function prints the two non-repeating elements in an
* array of repeating elements*/

static void get2NonRepeatingNos(int arr[], int n)
{
	/*Create map and calculate frequency of array
	elements.*/

	// Create a Map Set to store the numbers
	HashSet<Integer> s = new HashSet<Integer>();
	for (int i = 0; i < n; i++)
	{
	/*Iterate through the array and check if each
		element is present or not in the set. If the
		element is present, remove it from the array
		otherwise add it to the set*/
	if (s.contains(arr[i]))
		s.remove(arr[i]);
	else
		s.add(arr[i]);
	}
	System.out.print("The 2 non repeating numbers are : ");
	for (int it : s)
	System.out.print(it + " ");
	System.out.println();
}

// Driver code
public static void main (String[] args) {

	int arr[] = {2, 3, 7, 9, 11, 2, 3, 11};
	int n = arr.length;
	get2NonRepeatingNos(arr, n);
}
}

// This code is contributed by sanjoy_62.
