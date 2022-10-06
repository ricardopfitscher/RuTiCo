//https://www.geeksforgeeks.org/find-whether-a-given-number-is-a-power-of-4-or-not/
//O(log n)
// Java program to check
// if given number is
// power of 4 or not
import java.io.*;
class GFG
{
	static int isPowerOfFour(int n)
	{
		int count = 0;
		
		/*Check if there is
		only one bit set in n*/
		int x = n & (n - 1);
		
		if ( n > 0 && x == 0)
		{
			/* count 0 bits
			before set bit */
			while(n > 1)
			{
				n >>= 1;
				count += 1;
			}
		
			/*If count is even
			then return true
			else false*/
			return (count % 2 == 0) ? 1 : 0;
		}
		
			/* If there are more than
			1 bit set then n is not a
			power of 4*/
		return 0;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int test_no = 64;
		
		if(isPowerOfFour(test_no)>0)
			System.out.println(test_no +
							" is a power of 4");
		else
			System.out.println(test_no +
							" is not a power of 4");
	}
}

// This code is contributed by mits
