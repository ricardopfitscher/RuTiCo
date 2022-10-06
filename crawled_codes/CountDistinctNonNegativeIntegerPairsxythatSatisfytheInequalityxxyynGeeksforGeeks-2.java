//https://www.geeksforgeeks.org/count-distinct-non-negative-pairs-x-y-satisfy-inequality-xx-yy-n-2/
//O(n^1/2)
// An efficient Java program to
// find different (x, y) pairs
// that satisfy x*x + y*y < n.
import java.io.*;

class GFG
{
	// This function counts number
	//of pairs (x, y) that satisfy
	// the inequality x*x + y*y < n.
	static int countSolutions(int n)
	{
		int x = 0, yCount, res = 0;
		
		// Find the count of different
		// y values for x = 0.
		for (yCount = 0; yCount * yCount < n; yCount++) ;
		
		// One by one increase value of x,
		// and find yCount forcurrent x. If
		// yCount becomes 0, then we have reached
		// maximum possible value of x.
		while (yCount != 0)
		{
			// Add yCount (count of different possible
			// values of y for current x) to result
			res += yCount;
			
			// Increment x
			x++;
			
			// Update yCount for current x. Keep reducing
			// yCount while the inequality is not satisfied.
			while (yCount != 0 && (x * x + (yCount - 1)
								* (yCount - 1) >= n))
			yCount--;
			
		}
		return res;
		
	}
	
	// Driver program
	public static void main(String args[])
	{
		System.out.println ( "Total Number of distinct Non-Negative pairs is "
							+countSolutions(6)) ;
		
	}
}

// This article is contributed by vt_m.
