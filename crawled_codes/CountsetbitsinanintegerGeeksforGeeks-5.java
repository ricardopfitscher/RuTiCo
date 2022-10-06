//https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
//O(n)
// Java implementation of the approach
class GFG {

	// Lookup table
	static int[] BitsSetTable256 = new int[256];

	// Function to initialise the lookup table
	public static void initialize()
	{

		// To initially generate the
		// table algorithmically
		BitsSetTable256[0] = 0;
		for (int i = 0; i < 256; i++) {
			BitsSetTable256[i] = (i & 1) + BitsSetTable256[i / 2];
		}
	}

	// Function to return the count
	// of set bits in n
	public static int countSetBits(int n)
	{
		return (BitsSetTable256[n & 0xff]
				+ BitsSetTable256[(n >> 8) & 0xff]
				+ BitsSetTable256[(n >> 16) & 0xff]
				+ BitsSetTable256[n >> 24]);
	}

	// Driver code
	public static void main(String[] args)
	{

		// Initialise the lookup table
		initialize();
		int n = 9;
		System.out.print(countSetBits(n));
	}
}
