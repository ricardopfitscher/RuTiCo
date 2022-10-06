//https://www.geeksforgeeks.org/program-to-find-whether-a-given-number-is-power-of-2/
//O(log n)
// Java program to find whether
// a no is power of two
import java.io.*;

class GFG {

	// Function to check if
	// x is power of 2
	static boolean isPowerOfTwo(int n)
	{
		if (n == 0)
			return false;
		
		while (n != 1)
		{
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}
		return true;
	}

	// Driver program
	public static void main(String args[])
	{
		if (isPowerOfTwo(31))
			System.out.println("Yes");
		else
			System.out.println("No");

		if (isPowerOfTwo(64))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

// This code is contributed by Nikita tiwari.
