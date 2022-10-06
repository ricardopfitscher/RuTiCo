//https://www.geeksforgeeks.org/minimum-cost-polygon-triangulation/
//O(n^3)
// Class to store a point in the Euclidean plane
class Point
{
int x, y;
public Point(int x, int y)
{
	this.x = x;
	this.y = y;
}

// Utility function to return the distance between two
// vertices in a 2-dimensional plane
public double dist(Point p)
{

	// The distance between vertices `(x1, y1)` & `(x2,
	// y2)` is `√((x2 − x1) ^ 2 + (y2 − y1) ^ 2)`
	return Math.sqrt((this.x - p.x) * (this.x - p.x)
					+ (this.y - p.y) * (this.y - p.y));
}
}

class GFG
{

// Function to calculate the weight of optimal
// triangulation of a convex polygon represented by a
// given set of vertices `vertices[i..j]`
public static double MWT(Point[] vertices, int i, int j)
{

	// If the polygon has less than 3 vertices,
	// triangulation is not possible
	if (j < i + 2)
	{
	return 0;
	}

	// keep track of the total weight of the minimum
	// weight triangulation of `MWT(i,j)`
	double cost = Double.MAX_VALUE;

	// consider all possible triangles `ikj` within the
	// polygon
	for (int k = i + 1; k <= j - 1; k++)
	{

	// The weight of a triangulation is the length
	// of perimeter of the triangle
	double weight = vertices[i].dist(vertices[j])
		+ vertices[j].dist(vertices[k])
		+ vertices[k].dist(vertices[i]);

	// choose the vertex `k` that leads to the
	// minimum total weight
	cost = Double.min(cost,
						weight + MWT(vertices, i, k)
						+ MWT(vertices, k, j));
	}
	return cost;
}

// Driver code
public static void main(String[] args)
{

	// vertices are given in clockwise order
	Point[] vertices
	= { new Point(0, 0), new Point(2, 0),
		new Point(2, 1), new Point(1, 2),
		new Point(0, 1) };

	System.out.println(MWT(vertices,
						0, vertices.length - 1));
}
}

// This code is contributed by Priiyadarshini Kumari
