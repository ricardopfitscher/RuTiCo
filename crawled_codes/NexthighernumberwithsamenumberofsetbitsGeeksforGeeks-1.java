//https://www.geeksforgeeks.org/next-higher-number-with-same-number-of-set-bits/
//O(1)
// Java Implementation on above approach
class GFG
{
	
// this function returns next higher
// number with same number of set bits as x.
static int snoob(int x)
{

int rightOne, nextHigherOneBit, rightOnesPattern, next = 0;

if(x > 0)
{

	// right most set bit
	rightOne = x & -x;

	// reset the pattern and set next higher bit
	// left part of x will be here
	nextHigherOneBit = x + rightOne;

	// nextHigherOneBit is now part [D] of the above explanation.

	// isolate the pattern
	rightOnesPattern = x ^ nextHigherOneBit;

	// right adjust pattern
	rightOnesPattern = (rightOnesPattern)/rightOne;

	// correction factor
	rightOnesPattern >>= 2;

	// rightOnesPattern is now part [A] of the above explanation.

	// integrate new pattern (Add [D] and [A])
	next = nextHigherOneBit | rightOnesPattern;
}

return next;
}

// Driver code
public static void main (String[] args)
{
	int x = 156;
	System.out.println("Next higher number with same" +
					"number of set bits is "+snoob(x));
}
}

// This code is contributed by mits
