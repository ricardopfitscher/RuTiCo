//https://www.geeksforgeeks.org/write-an-efficient-method-to-check-if-a-number-is-multiple-of-3/
//O(n)
// JAVA program to check if n is a multiple of 3

import java.util.*;

class GFG{

static int []dp ;

/* Function to check if n is a multiple of 3*/
static int isMultipleOf3(int n)
{
	int odd_count = 0;
	int even_count = 0;
	
	// Base Cases
	if (n < 0)
		n = -n;
		
	if (n == 0)
		return 1;
		
	if (n == 1)
	return 0;
	
	// If a value is already present
	// in dp, return it
	if(dp[n] != -1)
		return dp[n];
	
	while (n > 0) {
		/* If odd bit is set then
		increment odd counter */
		if ((n & 1) != 0)
			odd_count++;

		/* If even bit is set then
		increment even counter */
		if ((n & 2) != 0)
			even_count++;
		n = n >> 2;
	}
	dp[n] = isMultipleOf3(Math.abs(odd_count - even_count));
	
	// return dp
	return dp[n];
}

/* Program to test function isMultipleOf3 */
public static void main(String[] args)
{
	int num = 24;
	dp = new int[1001];
	Arrays.fill(dp, -1);
	
	if (isMultipleOf3(num) == 1)
		System.out.printf("%d is multiple of 3", num);
	else
		System.out.printf("%d is not a multiple of 3", num);
}
}

// This codeiscontributed by Rajput-Ji
