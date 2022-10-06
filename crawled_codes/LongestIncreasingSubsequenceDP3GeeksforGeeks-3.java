//https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
//O(n log n)
import static java.lang.Math.max;

import java.util.SortedSet;
import java.util.TreeSet;

// Dynamic Programming Approach of Finding LIS by reducing
// the problem to longest common Subsequence
public class Main {

	/* lis() returns the length of the longest
	increasing subsequence in arr[] of size n */
	static int lis(int arr[], int n)
	{
		SortedSet<Integer> hs = new TreeSet<Integer>();
		// Storing and Sorting unique elements.
		for (int i = 0; i < n; i++)
			hs.add(arr[i]);
		int lis[] = new int[hs.size()];
		int k = 0;
		// Storing all the unique values in a sorted manner.
		for (int val : hs) {
			lis[k] = val;
			k++;
		}
		int m = k, i, j;
		int dp[][] = new int[m + 1][n + 1];

		// Storing -1 in dp multidimensional array.
		for (i = 0; i < m + 1; i++) {
			for (j = 0; j < n + 1; j++) {
				dp[i][j] = -1;
			}
		}

		// Finding the Longest Common Subsequence of the two
		// arrays
		for (i = 0; i < m + 1; i++) {
			for (j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
				else if (arr[j - 1] == lis[i - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
				else {
					dp[i][j]
						= max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

	// Driver Program for the above test function.
	public static void main(String[] args)
	{
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis(arr, n)
						+ "\n");
	}
}

// This Code is Contributed by Omkar Subhash Ghongade
