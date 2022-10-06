//https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
//O(log|n|)
// Java program for the above approach
import java.io.*;

class GFG {
	public static int power(int x, int y)
	{
		
		// If x^0 return 1
		if (y == 0)
			return 1;
		
		// If we need to find of 0^y
		if (x == 0)
			return 0;
		
		// For all other cases
		return x * power(x, y - 1);
	}
	
	// Driver Code
	public static void main(String[] args)
	{
		int x = 2;
		int y = 3;

		System.out.println(power(x, y));
	}
}
