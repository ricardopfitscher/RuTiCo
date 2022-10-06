//https://www.geeksforgeeks.org/smallest-of-three-integers-without-comparison-operators/
//O(1)
// Java program of above approach
class GfG {

	// Using division operator to
	// find minimum of three numbers
	static int smallest(int x, int y, int z)
	{
		if ((y / x) != 1) // Same as "if (y < x)"
			return ((y / z) != 1) ? y : z;
		return ((x / z) != 1) ? x : z;
	}

	// Driver code
	public static void main(String[] args)
	{
		int x = 78, y = 88, z = 68;
		System.out.printf("Minimum of 3 numbers"
							+ " is %d",
						smallest(x, y, z));
	}
}

// This code has been contributed by 29AjayKumar
