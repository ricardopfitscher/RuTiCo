//https://www.geeksforgeeks.org/position-of-rightmost-set-bit/
//O(log n)
// Java Code for Position of rightmost set bit
class GFG {

	public static int getFirstSetBitPos(int n)
	{
		return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1;
	}

	// Drive code
	public static void main(String[] args)
	{
		int n = 12;
		System.out.println(getFirstSetBitPos(n));
	}
}
// This code is contributed by Arnav Kr. Mandal
