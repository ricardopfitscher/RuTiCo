//https://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
//O(2^n)
// A Java naive recursive solution to find min cost path from station 0
// to station N-1
class shortest_path
{

	static int INF = Integer.MAX_VALUE,N = 4;
	// A recursive function to find the shortest path from
	// source 's' to destination 'd'.
	static int minCostRec(int cost[][], int s, int d)
	{
		// If source is same as destination
		// or destination is next to source
		if (s == d || s+1 == d)
		return cost[s][d];
	
		// Initialize min cost as direct ticket from
		// source 's' to destination 'd'.
		int min = cost[s][d];
	
		// Try every intermediate vertex to find minimum
		for (int i = s+1; i<d; i++)
		{
			int c = minCostRec(cost, s, i) +
					minCostRec(cost, i, d);
			if (c < min)
			min = c;
		}
		return min;
	}
	
	// This function returns the smallest possible cost to
	// reach station N-1 from station 0. This function mainly
	// uses minCostRec().
	static int minCost(int cost[][])
	{
		return minCostRec(cost, 0, N-1);
	}

	public static void main(String args[])
	{
		int cost[][] = { {0, 15, 80, 90},
					{INF, 0, 40, 50},
					{INF, INF, 0, 70},
					{INF, INF, INF, 0}
					};
		System.out.println("The Minimum cost to reach station "+ N+
											" is "+minCost(cost));
	}

}/* This code is contributed by Rajat Mishra */
