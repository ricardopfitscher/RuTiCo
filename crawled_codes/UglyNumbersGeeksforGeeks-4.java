//https://www.geeksforgeeks.org/ugly-numbers/
//O(n log n)
// JAVA program for the above approach
import java.util.*;

class GFG
{
static int upperBound(int[] a, int low,
						int high, int element)
{
	while(low < high)
	{
	int middle = low + (high - low)/2;
	if(a[middle] > element)
		high = middle;
	else
		low = middle + 1;
	}
	return low;
}

// Print nth Ugly number
static int nthUglyNumber(int n)
{

	int pow[] = new int[40];
	Arrays.fill(pow, 1);

	// stored powers of 2 from
	// Math.pow(2,0) to Math.pow(2,30)
	for (int i = 1; i <= 30; ++i)
	pow[i] = pow[i - 1] * 2;

	// Initialized low and high
	int l = 1, r = 2147483647;

	int ans = -1;

	// Applying Binary Search
	while (l <= r) {

	// Found mid
	int mid = l + ((r - l) / 2);

	// cnt stores total numbers of ugly
	// number less than mid
	int cnt = 0;

	// Iterate from 1 to mid
	for (long i = 1; i <= mid; i *= 5)

	{
		// Possible powers of i less than mid is i
		for (long j = 1; j * i <= mid; j *= 3)

		{
		// possible powers of 3 and 5 such that
		// their product is less than mid

		// using the power array of 2 (pow) we are
		// trying to find the max power of 2 such
		// that i*J*power of 2 is less than mid

		cnt += upperBound(pow,0, 31,
							(int)(mid / (i * j)));
		}
	}

	// If total numbers of ugly number
	// less than equal
	// to mid is less than n we update l
	if (cnt < n)
		l = mid + 1;

	// If total numbers of ugly number
	// less than equal to
	// mid is greater than n we update
	// r and ans simultaneously.
	else {
		r = mid - 1; ans = mid;
	}
	}

	return ans;
}

// Driver Code
public static void main(String[] args)
{

	int n = 150;

	// Function Call
	System.out.print(nthUglyNumber(n));
}
}

// This code is contributed by Rajput-Ji
