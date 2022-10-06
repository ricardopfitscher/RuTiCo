//https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
//O(n)
// Java program for the above approach
import java.util.*;
import java.awt.Point;
class GFG
{
// Function to count minimum
// squares that sum to n
public static int numSquares(int n)
{

	// Creating visited vector
	// of size n + 1
	int visited[] = new int[n + 1];

	// Queue of pair to store node
	// and number of steps
	Queue<Point> q = new LinkedList<>();

	// Initially ans variable is
	// initialized with inf
	int ans = Integer.MAX_VALUE;

	// Push starting node with 0
	// 0 indicate current number
	// of step to reach n
	q.add(new Point(n, 0));

	// Mark starting node visited
	visited[n] = 1;
	while(q.size() != 0)
	{
	Point p = q.peek();
	q.poll();

	// If node reaches its destination
	// 0 update it with answer
	if(p.x == 0)
		ans = Math.min(ans, p.y);

	// Loop for all possible path from
	// 1 to i*i <= current node(p.first)
	for(int i = 1; i * i <= p.x; i++)
	{

		// If we are standing at some node
		// then next node it can jump to will
		// be current node-
		// (some square less than or equal n)
		int path = (p.x - (i * i));

		// Check if it is valid and
		// not visited yet
		if(path >= 0 && (visited[path] == 0 || path == 0))
		{

		// Mark visited
		visited[path] = 1;

		// Push it it Queue
		q.add(new Point(path, p.y + 1));
		}
	}
	}

	// Return ans to calling function
	return ans;
}

// Driver code
public static void main(String[] args)
{
	System.out.println(numSquares(12));
}
}

// This code is contributed by divyesh072019
