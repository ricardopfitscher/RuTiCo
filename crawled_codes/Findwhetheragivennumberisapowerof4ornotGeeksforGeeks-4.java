//https://www.geeksforgeeks.org/find-whether-a-given-number-is-a-power-of-4-or-not/
//O(log n)
// Java program to check
// if given number is
// power of 4 or not
import java.util.*;
class GFG{

static double logn(int n,
				int r)
{
return Math.log(n) /
		Math.log(r);
}

static boolean isPowerOfFour(int n)
{
// 0 is not considered
// as a power of 4
if (n == 0)
	return false;
return Math.floor(logn(n, 4)) ==
		Math.ceil(logn(n, 4));
}

// Driver code
public static void main(String[] args)
{
int test_no = 64;
if (isPowerOfFour(test_no))
	System.out.print(test_no +
					" is a power of 4");
else
	System.out.print(test_no +
					" is not a power of 4");
}
}

// This code is contributed by Amit Katiyar
