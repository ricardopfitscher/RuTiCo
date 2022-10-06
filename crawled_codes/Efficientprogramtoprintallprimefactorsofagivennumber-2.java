//https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
//O(n)
import java.util.*;
class GFG {
	public static void primeFactors(int n)
	{
		int c = 2;
		while (n > 1) {
			if (n % c == 0) {
				System.out.print(c + " ");
				n /= c;
			}
			else
				c++;
		}
	}

	/* Driver code */
	public static void main(String[] args)
	{
		int n = 315;
		primeFactors(n);
	}
}

// This code is contributed by Taranpreet
