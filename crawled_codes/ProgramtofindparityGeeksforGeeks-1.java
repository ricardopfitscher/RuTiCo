//https://www.geeksforgeeks.org/program-to-find-parity/
//O(1)
// Java program to find parity
// of an integer
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class GFG
{
	/* Function to get parity of number n.
	It returns 1 if n has odd parity, and
	returns 0 if n has even parity */
	static boolean getParity(int n)
	{
		boolean parity = false;
		while(n != 0)
		{
			parity = !parity;
			n = n & (n-1);
		}
		return parity;
		
	}
	
	/* Driver program to test getParity() */
	public static void main (String[] args)
	{
		int n = 7;
		System.out.println("Parity of no " + n + " = " +
						(getParity(n)? "odd": "even"));
	}
}
/* This code is contributed by Amit khandelwal*/
