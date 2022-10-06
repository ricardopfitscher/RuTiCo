//https://www.geeksforgeeks.org/binomial-coefficient-dp-9/
//O(n+k)
// JAVA program for the above approach
import java.util.*;
class GFG
{

// Function to find binomial
// coefficient
static int binomialCoeff(int n, int r)
{

	if (r > n)
	return 0;
	long m = 1000000007;
	long inv[] = new long[r + 1];
	inv[0] = 1;
	if(r+1>=2)
	inv[1] = 1;

	// Getting the modular inversion
	// for all the numbers
	// from 2 to r with respect to m
	// here m = 1000000007
	for (int i = 2; i <= r; i++) {
		inv[i] = m - (m / i) * inv[(int) (m % i)] % m;
	}

	int ans = 1;

	// for 1/(r!) part
	for (int i = 2; i <= r; i++) {
		ans = (int) (((ans % m) * (inv[i] % m)) % m);
	}

	// for (n)*(n-1)*(n-2)*...*(n-r+1) part
	for (int i = n; i >= (n - r + 1); i--) {
		ans = (int) (((ans % m) * (i % m)) % m);
	}
	return ans;
}

/* Driver code*/
public static void main(String[] args)
{
	int n = 5, r = 2;
	System.out.print("Value of C(" + n+ ", " + r+ ") is "
		+binomialCoeff(n, r) +"\n");
}
}

// This code contributed by Rajput-Ji
