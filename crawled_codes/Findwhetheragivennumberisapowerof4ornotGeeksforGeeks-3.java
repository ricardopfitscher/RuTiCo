//https://www.geeksforgeeks.org/find-whether-a-given-number-is-a-power-of-4-or-not/
//O(log n)
// Java program to check
// if given number is
// power of 4 or not
import java.io.*;
class GFG {
	static boolean isPowerOfFour(int n) {
		return n != 0 && ((n&(n-1)) == 0) && (n & 0xAAAAAAAA) == 0;
	}

	// Driver Code
	public static void main(String[] args) {
		int test_no = 64;
		
		if(isPowerOfFour(test_no))
			System.out.println(test_no +
							" is a power of 4");
		else
			System.out.println(test_no +
							" is not a power of 4");
	}
}
