//https://www.geeksforgeeks.org/position-of-rightmost-set-bit/
//O(1)
// Java program for above approach
import java.io.*;

class GFG{
	
// Function to find position of
// rightmost set bit
public static int Last_set_bit(int n)
{
	int p = 1;

	// Iterate till number>0
	while (n > 0)
	{
		
		// Checking if last bit is set
		if ((n & 1) > 0)
		{
			return p;
		}

		// Increment position and
		// right shift number
		p++;
		n = n >> 1;
	}

	// set bit not found.
	return -1;
}

// Driver Code
public static void main(String[] args)
{
	int n = 18;

	// Function call
	int pos = Last_set_bit(n);

	if (pos != -1)
		System.out.println(pos);
	else
		System.out.println("0");
}
}

// This code is contributed by RohitOberoi
