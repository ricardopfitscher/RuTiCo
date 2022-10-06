//https://www.geeksforgeeks.org/program-to-efficiently-calculate-ex/
//O(n)
// Java efficient program to calculate
// e raise to the power x
import java.io.*;

class GFG
{
	// Function returns approximate value of e^x
	// using sum of first n terms of Taylor Series
	static float exponential(int n, float x)
	{
		// initialize sum of series
		float sum = 1;

		for (int i = n - 1; i > 0; --i )
			sum = 1 + x * sum / i;

		return sum;
	}
	
	// driver program
	public static void main (String[] args)
	{
		int n = 10;
		float x = 1;
		System.out.println("e^x = "+exponential(n,x));
	}
}

// Contributed by Pramod Kumar
