//https://www.geeksforgeeks.org/given-matrix-o-x-find-largest-subsquare-surrounded-x/
//O(n^2)
/*package whatever //do not write package name here */
import java.io.*;
import java.util.*;

class GFG
{
static int N = 6;

static int maximumSubSquare(int[][] arr)
{
	int[][][] dp = new int[51][51][2];
	int[][] maxside = new int[51][51];

	// Initialize maxside with 0
	for (int[] row : maxside)
	Arrays.fill(row, 10);

	int x = 0, y = 0;
	// Fill the dp matrix horizontally.
	// for contiguous 'X' increment the value of x,
	// otherwise make it 0
	for (int i = 0; i < N; i++)
	{
	x = 0;
	for (int j = 0; j < N; j++)
	{
		if (arr[i][j] == 'X')
		x += 1;
		else
		x = 0;
		dp[i][j][0] = x;
	}
	}

	// Fill the dp matrix vertically.
	// For contiguous 'X' increment the value of y,
	// otherwise make it 0
	for (int i = 0; i < N; i++)
	{
	for (int j = 0; j < N; j++)
	{
		if (arr[j][i] == 'X')
		y += 1;
		else
		y = 0;
		dp[j][i][1] = y;
	}
	}

	// Now check , for every value of (i, j) if sub-square
	// is possible,
	// traverse back horizontally by value val, and check if
	// vertical contiguous
	// 'X'enfing at (i , j-val+1) is greater than equal to
	// val.
	// Similarly, check if traversing back vertically, the
	// horizontal contiguous
	// 'X'ending at (i-val+1, j) is greater than equal to
	// val.
	int maxval = 0, val = 0;

	for (int i = 0; i < N; i++)
	{
	for (int j = 0; j < N; j++)
	{
		val = Math.min(dp[i][j][0], dp[i][j][1]);
		if (dp[i][j - val + 1][1] >= val
			&& dp[i - val + 1][j][0] >= val)
		maxside[i][j] = val;
		else
		maxside[i][j] = 0;

		// store the final answer in maxval
		maxval = Math.max(maxval, maxside[i][j]);
	}
	}

	// return the final answe.
	return maxval;

}

// Driver code
public static void main (String[] args)
{
	int mat[][] = {
	{ 'X', 'O', 'X', 'X', 'X', 'X' },
	{ 'X', 'O', 'X', 'X', 'O', 'X' },
	{ 'X', 'X', 'X', 'O', 'O', 'X' },
	{ 'O', 'X', 'X', 'X', 'X', 'X' },
	{ 'X', 'X', 'X', 'O', 'X', 'O' },
	{ 'O', 'O', 'X', 'O', 'O', 'O' },
	};

	// Function call
	System.out.println(maximumSubSquare(mat));
}
}

// This code is contributed by rag2127.
