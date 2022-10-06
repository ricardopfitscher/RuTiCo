//https://www.geeksforgeeks.org/count-sum-of-digits-in-numbers-from-1-to-n/
//O(|n|)
// JAVA program to compute sum of digits
// in numbers from 1 to n
import java.io.*;
import java.math.*;

class GFG{
	
	// Function to computer sum of digits in
	// numbers from 1 to n
	static int sumOfDigitsFrom1ToN(int n)
	{
		int d = (int)(Math.log10(n));
		int a[] = new int[d+1];
		a[0] = 0; a[1] = 45;
		for (int i = 2; i <= d; i++)
			a[i] = a[i-1] * 10 + 45 *
				(int)(Math.ceil(Math.pow(10, i-1)));
	
		return sumOfDigitsFrom1ToNUtil(n, a);
	}
	
	static int sumOfDigitsFrom1ToNUtil(int n, int a[])
	{
		if (n < 10)
			return (n * (n + 1) / 2);
	
		int d = (int)(Math.log10(n));
		int p = (int)(Math.ceil(Math.pow(10, d)));
		int msd = n / p;
		return (msd * a[d] + (msd * (msd - 1) / 2) * p +
			msd * (1 + n % p) + sumOfDigitsFrom1ToNUtil(n % p, a));
	}
	
	// Driver Program
	public static void main(String args[])
	{
		int n = 328;
		System.out.println("Sum of digits in numbers " +
						"from 1 to " +n + " is " +
						sumOfDigitsFrom1ToN(n));
	}
}

/*This code is contributed by Narendra Jha.*/
