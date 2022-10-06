//https://www.geeksforgeeks.org/count-distinct-non-negative-pairs-x-y-satisfy-inequality-xx-yy-n-2/
//O(n)
// Java code to Count Distinct
// Non-Negative Integer Pairs
// (x, y) that Satisfy the
// inequality x*x + y*y < n
import java.io.*;

class GFG
{
	// This function counts number
	// of pairs (x, y) that satisfy
	// the inequality x*x + y*y < n.
	static int countSolutions(int n)
	{
		int res = 0;
		for (int x = 0; x * x < n; x++)
			for (int y = 0; x * x + y * y < n; y++)
				res++;
				
		return res;
	}

	// Driver program
	public static void main(String args[])
	{
		System.out.println ( "Total Number of distinct Non-Negative pairs is "
														+countSolutions(6));
		
	}
}

// This article is contributed by vt_m.
