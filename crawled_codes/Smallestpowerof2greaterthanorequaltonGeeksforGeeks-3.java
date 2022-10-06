//https://www.geeksforgeeks.org/smallest-power-of-2-greater-than-or-equal-to-n/
//O(log n)
// Java program to find smallest
// power of 2 greater than or
// equal to n
import java.io.*;

class GFG
{
	// Finds next power of two
	// for n. If n itself is a
	// power of two then returns n
	static int nextPowerOf2(int n)
	{
		n--;
		n |= n >> 1;
		n |= n >> 2;
		n |= n >> 4;
		n |= n >> 8;
		n |= n >> 16;
		n++;
		
		return n;
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
