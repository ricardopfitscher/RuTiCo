//https://www.geeksforgeeks.org/program-to-find-whether-a-given-number-is-power-of-2/
//O(1)
// Java Program to find whether a
// no is power of two
class GFG
{
/* Function to check if x is power of 2*/
static boolean isPowerOfTwo(int n)
{
	if(n==0)
	return false;

return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==
	(int)(Math.floor(((Math.log(n) / Math.log(2)))));
}

// Driver Code
public static void main(String[] args)
{
	if(isPowerOfTwo(31))
	System.out.println("Yes");
	else
	System.out.println("No");
	
	if(isPowerOfTwo(64))
	System.out.println("Yes");
	else
	System.out.println("No");
}
}

// This code is contributed by mits
