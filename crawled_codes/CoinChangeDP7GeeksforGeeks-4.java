//https://www.geeksforgeeks.org/coin-change-dp-7/
//O(mn)
// Java program for the above approach
import java.util.*;

class GFG {

	static int coinchange(int[] a, int v, int n, int[][] dp)
	{
		if (v == 0)
			return dp[n][v] = 1;
		if (n == 0)
			return 0;
		if (dp[n][v] != -1)
			return dp[n][v];
		if (a[n - 1] <= v)
		{
		
			// Either Pick this coin or not
			return dp[n][v]
				= coinchange(a, v - a[n - 1], n, dp)
				+ coinchange(a, v, n - 1, dp);
		}
		else // We have no option but to leave this coin
			return dp[n][v] = coinchange(a, v, n - 1, dp);
	}

// Driver code
	public static void main(String[] args)
	{
		int tc = 1;
		while (tc != 0) {
			int n, v;
			n = 3;
			v = 4;
			int[] a = { 1, 2, 3 };
			int[][] dp = new int[n + 1][v + 1];
			for (int[] row : dp)
				Arrays.fill(row, -1);
			int res = coinchange(a, v, n, dp);
			System.out.println(res);
			tc--;
		}
	}
}

// This code is contributed by rajsanghavi9.
