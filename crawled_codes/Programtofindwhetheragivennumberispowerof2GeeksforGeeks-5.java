//https://www.geeksforgeeks.org/program-to-find-whether-a-given-number-is-power-of-2/
//O(1)
// Java program of the above approach
import java.io.*;

class GFG {

	// Function to check if x is power of 2
	static boolean isPowerofTwo(int n)
	{
		if (n == 0)
			return false;
		if ((n & (~(n - 1))) == n)
			return true;
		return false;
	}
	public static void main(String[] args)
	{
		if (isPowerofTwo(30) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	
		if (isPowerofTwo(128) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
				
	}
}

// This code is contributed by rajsanghavi9.
