//https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
//O(n)
// Java program for the above approach
import java.util.*;

class GFG
{

// Function to count minimum
// squares that sum to n
static int numSquares(int n)
{

	// Making the array of perfect squares less than or equal to n
	Vector <Integer> arr = new Vector<>();
	int k = 1;
	while(k * k <= n){
		arr.add(k * k);
		k++;
	}

	// A dp array which will store minimum number of perfect squares
	// required to make n from i at i th index
int []dp = new int[n + 1];
Arrays.fill(dp, Integer.MAX_VALUE);
	dp[n] = 0;
	for(int i = n - 1; i >= 0; i--)
	{
	
		// checking from i th value to n value minimum perfect squares required
		for(int j = 0; j < arr.size(); j++)
		{
		
			// check if index doesn't goes out of bound
			if(i + arr.elementAt(j) <= n)
			{
				dp[i] = Math.min(dp[i], dp[i+arr.elementAt(j)]);
			}
		}
	
		// from current to go to min step one i we need to take one step
		dp[i]++;
	}
	return dp[0];
}

// Driver code
public static void main(String[] args)
{
	System.out.print(numSquares(12));
}
}

// This code is contributed by umadevi9616.
