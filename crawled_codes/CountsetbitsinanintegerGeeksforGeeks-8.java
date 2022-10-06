//https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
//O(log n)
public class GFG
{

// Check each bit in a number is set or not
// and return the total count of the set bits.
static int countSetBits(int N)
{
	int count = 0;
	// (1 << i) = pow(2, i)
	for (int i = 0; i < 4 * 8; i++)
	{
	if ((N & (1 << i)) != 0)
		count++;
	}
	return count;
}

// Driver code
public static void main(String[] args)
{
	int N = 15;
	System.out.println(countSetBits(N));
}
}

// This code is contributed by divyeshrabadiya07.
