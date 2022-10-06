//https://www.geeksforgeeks.org/position-of-rightmost-set-bit/
//O(log n)
// Java program to find the
// position of first rightmost
// set bit in a given number
import java.util.*;

class GFG{

// Function to find rightmost
// set bit in given number.
static int getFirstSetBitPos(int n)
{
	return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1;
}

// Driver code
public static void main(String[] args)
{
	int n = 12;
	System.out.print( getFirstSetBitPos(n));
		
}
}

// This code is contributed by sanjoy_62.
