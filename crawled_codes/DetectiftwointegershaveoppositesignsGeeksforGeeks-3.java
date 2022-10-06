//https://www.geeksforgeeks.org/detect-if-two-integers-have-opposite-signs/
//O(1)
import java.io.*;

class GFG {
static boolean oppositeSigns(int x, int y)
{
	return ((x ^ y) >> 31);
}

	}

// This code is contributed by shivanisinghss2110
