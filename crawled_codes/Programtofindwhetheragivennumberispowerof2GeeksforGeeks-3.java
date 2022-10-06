//https://www.geeksforgeeks.org/program-to-find-whether-a-given-number-is-power-of-2/
//O(log n)
// Java program for
// the above approach
import java.util.*;
class GFG{

// Function which checks
// whether a number is a
// power of 2
static boolean powerOf2(int n)
{
// base cases
// '1' is the only odd number
// which is a power of 2(2^0)
if (n == 1)
	return true;

// all other odd numbers are
// not powers of 2
else if (n % 2 != 0 ||
		n ==0)
	return false;

// recursive function call
return powerOf2(n / 2);
}

// Driver Code
public static void main(String[] args)
{
//True
int n = 64;

//False
int m = 12;

if (powerOf2(n) == true)
	System.out.print("True" + "\n");
else System.out.print("False" + "\n");

if (powerOf2(m) == true)
	System.out.print("True" + "\n");
else
	System.out.print("False" + "\n");
}
}

// This code is contributed by Princi Singh
