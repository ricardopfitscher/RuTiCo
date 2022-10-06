//https://www.geeksforgeeks.org/detect-if-two-integers-have-opposite-signs/
//O(1)
// Java program for the above approach
import java.util.*;

class GFG {

static boolean oppositeSigns(int x, int y)
{
	long product = 1*x*y;
	return (product<0);
}

// Driver Code
public static void main(String[] args)
{
	int x = 100, y = -100;
	if (oppositeSigns(x, y) == true)
	System.out.print( "Signs are opposite");
	else
	System.out.print("Signs are not opposite");
}
}

// This code is contributed by sanjoy_62.
