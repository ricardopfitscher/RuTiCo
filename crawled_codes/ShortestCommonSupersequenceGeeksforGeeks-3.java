//https://www.geeksforgeeks.org/shortest-common-supersequence/
//O(mn)
// A dynamic programming based Java program to
// find length of the shortest supersequence
class GFG {

	// Returns length of the shortest
	// supersequence of X and Y
	static int superSeq(String X, String Y, int m, int n)
	{
		int[][] dp = new int[m + 1][n + 1];

		// Fill table in bottom up manner
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// Below steps follow above recurrence
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = 1
							+ Math.min(dp[i - 1][j],
										dp[i][j - 1]);
			}
		}

		return dp[m][n];
	}

	// Driver Code
	public static void main(String args[])
	{
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		System.out.println(
			"Length of the shortest supersequence is "
			+ superSeq(X, Y, X.length(), Y.length()));
	}
}

// This article is contributed by Sumit Ghosh
