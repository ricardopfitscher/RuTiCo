//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
//O(nw)
import java.util.*;
class GFG {

// we can further improve the above Knapsack function's space
// complexity
static int knapSack(int W, int wt[], int val[], int n)
{
	int i, w;
	int [][]K = new int[2][W + 1];
	
	// We know we are always using the current row or
	// the previous row of the array/vector . Thereby we can
	// improve it further by using a 2D array but with only
	// 2 rows i%2 will be giving the index inside the bounds
	// of 2d array K
	for (i = 0; i <= n; i++) {
	for (w = 0; w <= W; w++) {
		if (i == 0 || w == 0)
		K[i % 2][w] = 0;
		else if (wt[i - 1] <= w)
		K[i % 2][w] = Math.max(
		val[i - 1]
		+ K[(i - 1) % 2][w - wt[i - 1]],
		K[(i - 1) % 2][w]);
		else
		K[i % 2][w] = K[(i - 1) % 2][w];
	}
	}
	return K[n % 2][W];
}

// Driver Code
public static void main(String[] args)
{
	int val[] = { 60, 100, 120 };
	int wt[] = { 10, 20, 30 };
	int W = 50;
	int n = val.length;

	System.out.print(knapSack(W, wt, val, n));

}
}

// This code is contributed by gauravrajput1
