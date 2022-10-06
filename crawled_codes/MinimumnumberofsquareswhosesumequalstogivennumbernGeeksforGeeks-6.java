//https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
//O(n)
// Java code for the above approach
import java.util.*;

class GFG{

// returns true if the input number x is a square number,
// else returns false
static boolean isSquare(int x)
{
	int sqRoot = (int)Math.sqrt(x);
	return (sqRoot * sqRoot == x);
}

// Function to count minimum squares that sum to n
static int cntSquares(int n)
{
	// ans = 1 if the number is a perfect square
	if (isSquare(n)) {
		return 1;
	}

	// ans = 2:
	// we check for each i if n - (i * i) is a perfect
	// square
	for (int i = 1; i <= (int)Math.sqrt(n); i++) {
		if (isSquare(n - (i * i))) {
			return 2;
		}
	}

	// ans = 4
	// possible if the number is representable in the form
	// 4^a (8*b + 7).
	while (n % 4 == 0) {
		n >>= 2;
	}
	if (n % 8 == 7) {
		return 4;
	}

	// since all the other cases have been evaluated, the
	// answer can only then be 3 if the program reaches here
	return 3;
}

// Driver Code
public static void main(String[] args)
{
	System.out.print(cntSquares(12) +"\n");
}
}

// This code is contributed by umadevi9616
