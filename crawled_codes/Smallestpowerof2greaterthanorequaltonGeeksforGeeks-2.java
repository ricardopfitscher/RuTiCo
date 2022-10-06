//https://www.geeksforgeeks.org/smallest-power-of-2-greater-than-or-equal-to-n/
//O(log n)
// Java program to find smallest
// power of 2 greater than or
// equal to n
import java.io.*;

class GFG
{
	static int nextPowerOf2(int n)
	{
		int p = 1;
		if (n > 0 && (n & (n - 1)) == 0)
			return n;

		while (p < n)
			p <<= 1;
	
		return p;
	}

	// Driver Code
	public static void main(String args[])
	{
		int n = 5;
		System.out.println(nextPowerOf2(n));
	}
}

// This article is contributed
// by Anshika Goyal.
