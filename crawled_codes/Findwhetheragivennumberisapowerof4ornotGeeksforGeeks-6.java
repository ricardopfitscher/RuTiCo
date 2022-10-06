//https://www.geeksforgeeks.org/find-whether-a-given-number-is-a-power-of-4-or-not/
//O(log n)
// Java program to check
// if given number is
// power of 4 or not
import java.util.*;

class GFG {

	// Function to check perfect square
	static boolean isPerfectSqaure(int n) {
		int x = (int) Math.sqrt(n);

		return (x * x == n);
	}

	static boolean isPowerOfFour(int n)
	{
	
		// If n <= 0, it is not the power of four
		if (n <= 0)
			return false;

		// Check whether 'n' is a perfect square or not
		if (!isPerfectSqaure(n))
			return false;

		// If 'n' is the perfect square
		// Check for the second condition i.e. 'n' must be power of two
		return (n & (n - 1)) != 1 ? true : false;
	}

	/* Driver code */
	public static void main(String[] args) {
		int test_no = 64;
		if (isPowerOfFour(test_no))
			System.out.print(test_no + " is a power of 4");
		else
			System.out.print(test_no + " is not a power of 4");
	}
}

// This code is contributed by gauravrajput1
