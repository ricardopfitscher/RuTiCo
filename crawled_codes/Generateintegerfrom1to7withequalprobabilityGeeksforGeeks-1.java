//https://www.geeksforgeeks.org/generate-integer-from-1-to-7-with-equal-probability/
//O(1)
// Java code to demonstrate
// expression returns each integer
// from 1 to 25 exactly once

class GFG {
	public static void main(String[] args)
	{
		int first, second;
		for ( first=1; first<=5; ++first )
			for ( second=1; second<=5; ++second )
			System.out.printf ("%d \n", 5*first + second - 5);
	}
}

// This code is contributed by
// Smitha Dinesh Semwal
