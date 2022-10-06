//https://www.geeksforgeeks.org/tiling-problem/
//O(2^n)
/* Java program to count the
no of ways to place 2*1 size
tiles in 2*n size board. */
import java.io.*;

class GFG {
static int getNoOfWays(int n)
{

	// Base case
	if (n <= 2) {
	return n;
	}
	return getNoOfWays(n - 1) + getNoOfWays(n - 2);
}

// Driver Function
public static void main(String[] args)
{
	System.out.println(getNoOfWays(4));
	System.out.println(getNoOfWays(3));
}
}

// This code is contributed by ashwinaditya21.
