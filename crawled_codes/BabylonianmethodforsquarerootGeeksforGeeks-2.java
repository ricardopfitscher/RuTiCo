//https://www.geeksforgeeks.org/square-root-of-a-perfect-square/
//O(n^1/2)
// Java program for Babylonian
// method for square root
import java.io.*;

public class GFG {

	/* Returns the square root of
	n. Note that the function
	will not work for numbers
	which are not perfect
	squares*/
	static long squareRoot(int n)
	{
		int x = n;
		int y = 1;
		while (x > y) {
			x = (x + y) / 2;
			y = n / x;
		}
		return (long)x;
	}

	// Driver Code
	static public void main(String[] args)
	{
		int n = 49;
		System.out.println("root of "
						+ n + " is " + squareRoot(n));
	}
}

// This code is contributed by anuj_67.
