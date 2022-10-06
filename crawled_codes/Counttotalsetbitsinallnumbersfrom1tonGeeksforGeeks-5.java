//https://www.geeksforgeeks.org/count-total-set-bits-in-all-numbers-from-1-to-n/
//O(log n)
import java.io.*;
class GFG
{
static int findLargestPower(int n)
{
	int x = 0;
	while ((1 << x) <= n)
		x++;
	return x - 1;
}

static int countSetBits(int n)
{
	if (n <= 1)
		return n;
	int x = findLargestPower(n);
	return (x * (int)Math.pow(2, (x - 1))) + (n - (int)Math.pow(2, x) + 1)
	+ countSetBits(n - (int)Math.pow(2, x));
}

public static void main(String[] args)
	{
	int N = 17;
	System.out.print(countSetBits(N));
}
}

// This code is contributed by shivanisinghss2110
