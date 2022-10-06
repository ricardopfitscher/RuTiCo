//https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
//O(log n)
static int Add(int x, int y)
{
if (y == 0)
	return x;
else
	return Add(x ^ y, (x & y) << 1);
}

// This code is contributed by subham348
