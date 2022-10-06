//https://www.geeksforgeeks.org/count-total-set-bits-in-all-numbers-from-1-to-n/
//O(k*n)
static int getSetBitsFromOneToN(int N){
	int two = 2,ans = 0;
	int n = N;
	while(n != 0)
	{
		ans += (N / two)*(two >> 1);
		if((N&(two - 1)) > (two >> 1) - 1)
			ans += (N&(two - 1)) - (two >> 1) + 1;
		two <<= 1;
		n >>= 1;
	}
	return ans;
}

// This code is contributed by divyeshrabadiya07.
