//https://www.geeksforgeeks.org/smallest-power-of-2-greater-than-or-equal-to-n/
//O(1)
// Java program to find
// smallest power of 2
// greater than or equal to n
import java.io.*;

class GFG {
	static long nextPowerOf2(long N)
	{
		// if N is a power of two simply return it
		if ((N & (N - 1)) == 0)
			return N;
		// else set only the left bit of most significant
		// bit as in Java right shift is filled with most
		// significant bit we consider
		return 0x4000000000000000L
			>> (Long.numberOfLeadingZeros(N) - 2);
	}

	// Driver Code
	public static void main(String args[])
	{
		long n = 5;
		System.out.println(nextPowerOf2(n));
	}
}

// This code is contributed
// by Kasina Dheeraj.
