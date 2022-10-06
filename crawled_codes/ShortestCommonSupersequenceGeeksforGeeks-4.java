//https://www.geeksforgeeks.org/shortest-common-supersequence/
//O(mn)
// A dynamic programming based python program
// to find length of the shortest supersequence

// Returns length of the
// shortest supersequence of X and Y
import java.util.*;

class GFG {

	static int superSeq(String X, String Y, int n, int m,
						int[][] lookup)
	{

		if (m == 0 || n == 0) {
			lookup[n][m] = n + m;
		}

		if (lookup[n][m] == 0)
			if (X.charAt(n - 1) == Y.charAt(m - 1)) {
				lookup[n][m]
					= superSeq(X, Y, n - 1, m - 1, lookup)
					+ 1;
			}

			else {
				lookup[n][m] = Math.min(
					superSeq(X, Y, n - 1, m, lookup) + 1,
					superSeq(X, Y, n, m - 1, lookup) + 1);
			}

		return lookup[n][m];
	}

	// Driver Code
	public static void main(String[] args)
	{
		String X = "AGGTB";
		String Y = "GXTXAYB";

		int[][] lookup
			= new int[X.length() + 1][Y.length() + 1];

		System.out.print(
			"Length of the shortest supersequence is "
			+ superSeq(X, Y, X.length(), Y.length(), lookup)
			+ "\n");
	}
}

// This code contributed by umadevi9616
