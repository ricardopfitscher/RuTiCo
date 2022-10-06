//https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
//O(n)
// Java program for the above approach
import java.io.*;

class GFG {
	public static int power(int x, int y)
	{
		
		// Math.pow() is a function that
		// return floating number
		return (int)Math.pow(x, y);
	}
	
	// Driver Code
	public static void main(String[] args)
	{
		int x = 2;
		int y = 3;

		System.out.println(power(x, y));
	}
}
