//https://www.geeksforgeeks.org/binomial-coefficient-dp-9/
//O(n*k)
// A Dynamic Programming based
// solution that uses
// table dp[][] to calculate
// the Binomial Coefficient
// A naive recursive approach
// with table Java implementation
import java.util.*;
class GFG{

// Returns value of Binomial
// Coefficient C(n, k)
static int binomialCoeffUtil(int n, int k,
							Vector<Integer> []dp)
{
// If value in lookup table
// then return
if (dp[n].get(k) != -1)	
	return dp[n].get(k);

// store value in a table
// before return
if (k == 0)
{
	dp[n].add(k, 1);
	return dp[n].get(k);
}

// store value in table
// before return
if (k == n)
{
	dp[n].add(k, 1);
	return dp[n].get(k);
}

// save value in lookup table
// before return
dp[n].add(k, binomialCoeffUtil(n - 1,
								k - 1, dp) +
			binomialCoeffUtil(n - 1,
								k, dp));
return dp[n].get(k);
}

static int binomialCoeff(int n, int k)
{
// Make a temporary lookup table
Vector<Integer> []dp = new Vector[n+1];

// Loop to create table dynamically
for (int i = 0; i < (n + 1); i++)
{
	dp[i] = new Vector<Integer>();
	for(int j = 0; j <= k; j++)
	dp[i].add(-1);
}
return binomialCoeffUtil(n, k, dp);
}

// Driver code
public static void main(String[] args)
{
int n = 5, k = 2;
System.out.print("Value of C(" + n +
				", " + k + ") is " +
				binomialCoeff(n, k) + "\n");
}
}

// This code is contributed by Rajput-Ji
