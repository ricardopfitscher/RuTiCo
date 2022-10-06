//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
//O(log n)
// Java Program to find n'th fibonacci Number
import java.util.*;

class GFG {

static int fib(int n) {
double phi = (1 + Math.sqrt(5)) / 2;
return (int) Math.round(Math.pow(phi, n)
						/ Math.sqrt(5));
}

// Driver Code
public static void main(String[] args) {
		int n = 9;
	System.out.println(fib(n));
	}
}
// This code is contributed by PrinciRaj1992
