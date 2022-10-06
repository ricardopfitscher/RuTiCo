//https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
//O(n)
// Java program to count number of
// ways to reach Nth stair
class GFG
{

// A simple recursive program to
// find N'th fibonacci number
static int fib(int n, int dp[])
{
	if (n <= 1)
	return dp[n] = 1;

	if (dp[n] != -1) {
	return dp[n];
	}
	dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
	return dp[n];
}

// Returns number of ways to
// reach s'th stair
static int countWays(int n)
{
	int[] dp = new int[n + 1];
	for (int i = 0; i < n + 1; i++) {
	dp[i] = -1;
	}
	fib(n, dp);
	return dp[n];
}

// Driver code
public static void main(String[] args)
{
	int n = 4;
	System.out.println(countWays(n));
}
}

// This code is contributed by Karandeep1234
