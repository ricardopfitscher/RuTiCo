//https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
//O(n)
// Java program for the above approach
import java.util.*;

class GFG {
	static int Kth_smallest(TreeMap<Integer, Integer> m,
							int k)
	{
		int freq = 0;
		for (Map.Entry it : m.entrySet())
		{
		
			// adding the frequencies of each element
			freq += (int)it.getValue();

			// if at any point frequency becomes
			// greater than or equal to k then
			// return that element
			if (freq >= k) {
				return (int)it.getKey();
			}
		}

		return -1; // returning -1 if k>size of the array
				// which is an impossible scenario
	}

// Driver code
	public static void main(String[] args)
	{
		int n = 5;
		int k = 2;
		int[] arr = { 12, 3, 5, 7, 19 };
		TreeMap<Integer, Integer> m = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			// mapping every element with
			// it's
			// frequency
			m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
		}
		int ans = Kth_smallest(m, k);
		if(k==1){
	System.out.println(
			"The " + k + "st smallest element is " + ans);
}
else if(k==2){
	System.out.println(
			"The " + k + "nd smallest element is " + ans);
}
else if(k==3){
	System.out.println(
			"The " + k + "rd smallest element is " + ans);
}
else{
	System.out.println(
			"The " + k + "th smallest element is " + ans);
}
		
	}
}

// This code is contributed by harshit17.
