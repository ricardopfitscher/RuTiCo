//https://www.geeksforgeeks.org/smallest-of-three-integers-without-comparison-operators/
//O(min(x, y, z))
// Java implementation of above approach
class GFG
{
	
static int CHAR_BIT = 8;

// Function to find minimum of x and y
static int min(int x, int y)
{
	return y + ((x - y) & ((x - y) >>
			((Integer.SIZE/8) * CHAR_BIT - 1)));
}

// Function to find minimum of 3 numbers x, y and z
static int smallest(int x, int y, int z)
{
	return Math.min(x, Math.min(y, z));
}

// Driver code
public static void main (String[] args)
{
	int x = 12, y = 15, z = 5;
	System.out.println("Minimum of 3 numbers is " +
								smallest(x, y, z));
}
}

// This code is contributed by mits
