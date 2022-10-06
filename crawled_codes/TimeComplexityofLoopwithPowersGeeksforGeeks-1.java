//https://www.geeksforgeeks.org/time-complexity-of-loop-with-powers/
//O(n^k)
static void fun(int n, int k)
{
	for (int i = 1; i <= n; i++)
	{
		int p = Math.pow(i, k);
		for (int j = 1; j <= p; j++)
		{
			// Some O(1) work
		}
	}
}

// This code is contributed by umadevi9616
