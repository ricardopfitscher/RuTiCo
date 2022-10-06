//https://www.geeksforgeeks.org/find-whether-a-given-number-is-a-power-of-4-or-not/
//O(log n)
// Java program to check
// if given number is
import java.io.*;

class GFG{
	
static boolean isPowerOfFour(int n)
{
	return (n > 0 && Math.pow(
		4, (int)((Math.log(n) /
				Math.log(2)) /
				(Math.log(4) /
				Math.log(2)))) == n);
}

// Driver code
public static void main(String[] args)
{
	int test_no = 64;
	
	if (isPowerOfFour(test_no))
		System.out.println(test_no +
		" is a power of 4");
	else
		System.out.println(test_no +
		" is not a power of 4");
}
}

// This code is contributed by rag2127
