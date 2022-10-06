//https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
//O(log n)
// Java program to count
// trailing 0s in n!
import java.io.*;

class GFG {
	// Function to return trailing
	// 0s in factorial of n
	static int findTrailingZeros(int n)
	{
		if (n < 0) // Negative Number Edge Case
			return -1;

		// Initialize result
		int count = 0;

		// Keep dividing n by powers
		// of 5 and update count
		for (int i = 5; n / i >= 1; i *= 5)
			count += n / i;

		return count;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int n = 100;
		System.out.println("Count of trailing 0s in " + n
						+ "! is "
						+ findTrailingZeros(n));
	}
}

// This code is contributed by Pramod Kumar
