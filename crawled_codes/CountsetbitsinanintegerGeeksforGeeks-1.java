//https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
//O(log n)
// Java program to Count set
// bits in an integer
import java.io.*;

class countSetBits {
	/* Function to get no of set
	bits in binary representation
	of positive integer n */
	static int countSetBits(int n)
	{
		int count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}

	// driver program
	public static void main(String args[])
	{
		int i = 9;
		System.out.println(countSetBits(i));
	}
}

// This code is contributed by Anshika Goyal.
