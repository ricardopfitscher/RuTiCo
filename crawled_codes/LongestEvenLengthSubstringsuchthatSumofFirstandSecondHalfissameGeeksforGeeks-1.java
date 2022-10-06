//https://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
//O(n^2)
// A simple Java based program to find
// length of longest even length substring
// with same sum of digits in left and right
import java.io.*;

class GFG {

static int findLength(String str)
{
	int n = str.length();
	int maxlen = 0; // Initialize result

	// Choose starting point of every
	// substring
	for (int i = 0; i < n; i++)
	{
		// Choose ending point of even
		// length substring
		for (int j = i + 1; j < n; j += 2)
		{
			// Find length of current substr
			int length = j - i + 1;

			// Calculate left & right sums
			// for current substr
			int leftsum = 0, rightsum = 0;
			for (int k = 0; k < length/2; k++)
			{
				leftsum += (str.charAt(i + k) - '0');
				rightsum += (str.charAt(i + k + length/2) - '0');
			}

			// Update result if needed
			if (leftsum == rightsum && maxlen < length)
					maxlen = length;
		}
	}
	return maxlen;
}

// Driver program to test above function
public static void main(String[] args)
{
	String str = "1538023";
	System.out.println("Length of the substring is "
					+ findLength(str));
}
}

// This code is contributed by Prerna Saini
