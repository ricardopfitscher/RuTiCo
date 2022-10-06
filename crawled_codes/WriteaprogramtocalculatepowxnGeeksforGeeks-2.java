//https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
//O(logn)
/* Function to calculate x raised to the power y in O(logn)*/
static int power(int x, int y)
{
	int temp;
	if( y == 0)
		return 1;
	temp = power(x, y / 2);
	if (y % 2 == 0)
		return temp*temp;
	else
		return x*temp*temp;
}

// This code is contributed by divyeshrabadiya07.
