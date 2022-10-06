//https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
//O(log n)
// Java implementation of recursive
// approach to find the number
// of set bits in binary representation
// of positive integer n
import java.io.*;

class GFG {

	// recursive function to count set bits
	public static int countSetBits(int n)
	{

		// base case
		if (n == 0)
			return 0;

		else

			// if last bit set add 1 else add 0
			return (n & 1) + countSetBits(n >> 1);
	}

	// Driver code
	public static void main(String[] args)
	{

		// get value from user
		int n = 9;

		// function calling
		System.out.println(countSetBits(n));
	}
}

// This code is contributes by sunnysingh
