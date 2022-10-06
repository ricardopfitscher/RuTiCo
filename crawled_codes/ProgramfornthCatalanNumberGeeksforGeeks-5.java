//https://www.geeksforgeeks.org/program-nth-catalan-number/
//O(n)
import java.io.*;
import java.util.*;
import java.math.*;

class GFG
{
	public static BigInteger findCatalan(int n)
	{
		// using BigInteger to calculate large factorials
		BigInteger b = new BigInteger("1");

		// calculating n!
		for (int i = 1; i <= n; i++) {
			b = b.multiply(BigInteger.valueOf(i));
		}

		// calculating n! * n!
		b = b.multiply(b);

		BigInteger d = new BigInteger("1");

		// calculating (2n)!
		for (int i = 1; i <= 2 * n; i++) {
			d = d.multiply(BigInteger.valueOf(i));
		}

		// calculating (2n)! / (n! * n!)
		BigInteger ans = d.divide(b);

		// calculating (2n)! / ((n! * n!) * (n+1))
		ans = ans.divide(BigInteger.valueOf(n + 1));
		return ans;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int n = 5;
		System.out.println(findCatalan(n));
	}
}
// Contributed by Rohit Oberoi
