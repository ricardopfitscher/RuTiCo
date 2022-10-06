//https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
//O(log n)
// Java program to count set bits by pre-storing
// count set bits in nibbles.

class GFG {
	static int[] num_to_bits = new int[] { 0, 1, 1, 2, 1, 2, 2,
										3, 1, 2, 2, 3, 2, 3, 3, 4 };

	/* Recursively get nibble of a given number
and map them in the array */
	static int countSetBitsRec(int num)
	{
		int nibble = 0;
		if (0 == num)
			return num_to_bits[0];

		// Find last nibble
		nibble = num & 0xf;

		// Use pre-stored values to find count
		// in last nibble plus recursively add
		// remaining nibbles.
		return num_to_bits[nibble] + countSetBitsRec(num >> 4);
	}

	// Driver code
	public static void main(String[] args)
	{
		int num = 31;
		System.out.println(countSetBitsRec(num));
	}
}
// this code is contributed by mits
