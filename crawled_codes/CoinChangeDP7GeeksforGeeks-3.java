//https://www.geeksforgeeks.org/coin-change-dp-7/
//O(mn)
public static int count( int S[], int m, int n )
{
	// table[i] will be storing the number of solutions for
	// value i. We need n+1 rows as the table is constructed
	// in bottom up manner using the base case (n = 0)
	int table[]=new int[n+1];

	// Base case (If given value is 0)
	table[0] = 1;

	// Pick all coins one by one and update the table[] values
	// after the index greater than or equal to the value of the
	// picked coin
	for(int i=0; i<m; i++)
		for(int j=S[i]; j<=n; j++)
			table[j] += table[j-S[i]];

	return table[n];
}
