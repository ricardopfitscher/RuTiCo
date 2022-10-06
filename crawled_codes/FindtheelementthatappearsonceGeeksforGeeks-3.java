//https://www.geeksforgeeks.org/find-the-element-that-appears-once/
//O(log n)
// Java program to find the element
// that occur only once
import java.util.*;

class GFG {

	// function which find number
	static int singleNumber(int a[], int n)
	{
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i : a) {
			s.add(i);
		}

		int arr_sum = 0; // sum of array
		for (int i : a) {
			arr_sum += i;
		}

		int set_sum = 0; // sum of set
		for (int i : s) {
			set_sum += i;
		}

		// applying the formula.
		return (3 * set_sum - arr_sum) / 2;
	}

	// Driver code
	public static void main(String[] args)
	{
		int a[] = { 12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7 };
		int n = a.length;
		System.out.println("The element with single "
						+ "occurrence is " + singleNumber(a, n));
	}
}

// This code is contributed by 29AjayKumar
