//https://www.geeksforgeeks.org/find-smallest-number-whose-digits-multiply-given-number-n/
//O(log n)
// Java program to find the smallest number whose
// digits multiply to a given number n

import java.io.*;

class Smallest
{
	// Function to prints the smallest number whose
	// digits multiply to n
	static void findSmallest(int n)
	{
		int i, j=0;
		int MAX = 50;
		// To store digits of result in reverse order
		int[] res = new int[MAX];

		// Case 1: If number is smaller than 10
		if (n < 10)
		{
			System.out.println(n+10);
			return;
		}

		// Case 2: Start with 9 and try every possible digit
		for (i=9; i>1; i--)
		{
			// If current digit divides n, then store all
			// occurrences of current digit in res
			while (n%i == 0)
			{
				n = n/i;
				res[j] = i;
				j++;
			}
		}

		// If n could not be broken in form of digits (prime factors of n
		// are greater than 9)
		if (n > 10)
		{
			System.out.println("Not possible");
			return;
		}

		// Print the result array in reverse order
		for (i=j-1; i>=0; i--)
			System.out.print(res[i]);
		System.out.println();
	}
	
	// Driver program
	public static void main (String[] args)
	{
		findSmallest(7);
		findSmallest(36);
		findSmallest(13);
		findSmallest(100);
	}
}

// Contributed by Pramod Kumar
