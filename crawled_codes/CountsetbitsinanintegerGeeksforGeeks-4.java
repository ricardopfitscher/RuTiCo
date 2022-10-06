//https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
//O(log n)
// Java implementation for recursive
// approach to find the number of set
// bits using Brian Kernighan Algorithm
import java.io.*;

class GFG {

	// recursive function to count set bits
	public static int countSetBits(int n)
	{

		// base case
		if (n == 0)
			return 0;
		else
			return 1 + countSetBits(n & (n - 1));
	}

	// Driver function
	public static void main(String[] args)
	{

		// get value from user
		int n = 9;

		// function calling
		System.out.println(countSetBits(n));
	}
}

// This code is contributed by sunnysingh
