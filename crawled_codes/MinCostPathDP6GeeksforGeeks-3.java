//https://www.geeksforgeeks.org/min-cost-path-dp-6/
//O(mn)
// Java program for the
// above approach
import java.util.*;
class GFG{

static int row = 3;
static int col = 3;

static int minCost(int cost[][])
{
// for 1st column
for (int i = 1; i < row; i++)
{
	cost[i][0] += cost[i - 1][0];
}

// for 1st row
for (int j = 1; j < col; j++)
{
	cost[0][j] += cost[0][j - 1];
}

// for rest of the 2d matrix
for (int i = 1; i < row; i++)
{
	for (int j = 1; j < col; j++)
	{
	cost[i][j] += Math.min(cost[i - 1][j - 1],
					Math.min(cost[i - 1][j],
							cost[i][j - 1]));
	}
}

// Returning the value in
// last cell
return cost[row - 1][col - 1];
}

// Driver code
public static void main(String[] args)
{	
int cost[][] = {{1, 2, 3},
				{4, 8, 2},
				{1, 5, 3} };
System.out.print(minCost(cost) + "\n");
}
}

// This code is contributed by Amit Katiyar
