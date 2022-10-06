//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
//O(log n)
import java.util.*;

class GFG{

// Initialize array of dp
static int[] dp = new int[10];

static int fib(int n)
{
	if (n <= 1)
		return n;
		
	// Temporary variables to store
	// values of fib(n-1) & fib(n-2)
	int first, second;
	
	if (dp[n - 1] != -1)
		first = dp[n - 1];
	else
		first = fib(n - 1);

	if (dp[n - 2] != -1)
		second = dp[n - 2];
	else
		second = fib(n - 2);

	// Memoization
	return dp[n] = first + second;
}

// Driver Code
public static void main(String[] args)
{
	int n = 9;

	Arrays.fill(dp, -1);

	System.out.print(fib(n));
}
}

// This code is contributed by sujitmeshram
