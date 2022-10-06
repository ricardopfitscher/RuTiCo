//https://www.geeksforgeeks.org/minimum-cost-polygon-triangulation/
//O(n^3)
// A Dynamic Programming based program to find minimum cost
// of convex polygon triangulation
import java.util.*;

class GFG
{

// Structure of a point in 2D plane
static class Point {
	int x, y;
	Point(int x, int y)
	{
	this.x = x;
	this.y = y;
	}
}

// Utility function to find minimum of two double values
static double min(double x, double y)
{
	return (x <= y) ? x : y;
}

// A utility function to find distance between two
// points in a plane
static double dist(Point p1, Point p2)
{
	return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x)
					+ (p1.y - p2.y) * (p1.y - p2.y));
}

// A utility function to find cost of a triangle. The
// cost is considered as perimeter (sum of lengths of
// all edges) of the triangle
static double cost(Point points[], int i, int j, int k)
{
	Point p1 = points[i], p2 = points[j],
	p3 = points[k];
	return dist(p1, p2) + dist(p2, p3) + dist(p3, p1);
}

// A Dynamic programming based function to find minimum
// cost for convex polygon triangulation.
static double mTCDP(Point points[], int n)
{
	// There must be at least 3 points to form a
	// triangle
	if (n < 3)
	return 0;

	// table to store results of subproblems.
	// table[i][j] stores cost of triangulation of
	// points from i to j. The entry table[0][n-1]
	// stores the final result.
	double[][] table = new double[n][n];

	// Fill table using above recursive formula. Note
	// that the table is filled in diagonal fashion
	// i.e., from diagonal elements to table[0][n-1]
	// which is the result.
	for (int gap = 0; gap < n; gap++) {
	for (int i = 0, j = gap; j < n; i++, j++) {
		if (j < i + 2)
		table[i][j] = 0.0;
		else {
		table[i][j] = 1000000.0;
		for (int k = i + 1; k < j; k++) {
			double val
			= table[i][k] + table[k][j]
			+ cost(points, i, j, k);
			if (table[i][j] > val)
			table[i][j] = val;
		}
		}
	}
	}
	return table[0][n - 1];
}

// Driver program to test above functions
public static void main(String[] args)
{
	Point[] points = { new Point(0, 0), new Point(1, 0),
					new Point(2, 1), new Point(1, 2),
					new Point(0, 2) };
	int n = points.length;
	System.out.println(mTCDP(points, n));
}
}

// This code is contributed by Karandeep Singh
