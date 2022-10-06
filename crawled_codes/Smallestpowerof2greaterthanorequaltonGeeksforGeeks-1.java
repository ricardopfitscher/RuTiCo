//https://www.geeksforgeeks.org/smallest-power-of-2-greater-than-or-equal-to-n/
//O(log n)
// Java program to find
// smallest power of 2
// greater than or equal to n
import java.io.*;

class GFG
{
	static int nextPowerOf2(int n)
	{
		int count = 0;

		// First n in the below
		// condition is for the
		// case where n is 0
		if (n > 0 && (n & (n - 1)) == 0)
			return n;

		while(n != 0)
		{
			n >>= 1;
			count += 1;
		}

		return 1 << count;
	}

	// Driver Code
	public static void main(String args[])
	{
		int n = 0;
		System.out.println(nextPowerOf2(n));
	}
}

// This article is contributed
// by Anshika Goyal.
