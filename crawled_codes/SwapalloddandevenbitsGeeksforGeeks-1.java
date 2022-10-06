//https://www.geeksforgeeks.org/swap-all-odd-and-even-bits/
//O(1)
// Java program to swap even and
// odd bits of a given number
import java.io.*;

class GFG {

	// Function to swap even
	// and odd bits
	static int swapBits(int x)
	{
		for (int i = 0; i < 32; i += 2) {
			int i_bit = (x >> i) & 1; // find i th bit
			int i_1_bit
				= (x >> (i + 1)) & 1; // find i+1 th bit

			x = x - (i_bit << i) // remove i_bit
				- (i_1_bit << (i + 1)) // remove i+1 th bit
				+ (i_bit
				<< (i + 1)) // put i_bit at i+1 location
				+ (i_1_bit
				<< i); // put i+1 bit at i location
		}
		return x;
	}

	// Driver code
	public static void main(String[] args)
	{
		int x = 23; // 00010111

		// Output is 43 (00101011)
		System.out.print(swapBits(x));
	}
}

// This code is contributed by subham348.
