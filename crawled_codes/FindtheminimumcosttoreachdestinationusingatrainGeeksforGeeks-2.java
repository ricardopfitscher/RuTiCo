//https://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
//O(n^2)
// A Dynamic Programming based solution to find min cost
// to reach station N-1 from station 0.
class shortest_path
{

	static int INF = Integer.MAX_VALUE,N = 4;
	// A recursive function to find the shortest path from
	// source 's' to destination 'd'.
	
	// This function returns the smallest possible cost to
	// reach station N-1 from station 0.
	static int minCost(int cost[][])
	{
		// dist[i] stores minimum cost to reach station i
		// from station 0.
		int dist[] = new int[N];
		for (int i=0; i<N; i++)
		dist[i] = INF;
		dist[0] = 0;
	
		// Go through every station and check if using it
		// as an intermediate station gives better path
		for (int i=0; i<N; i++)
		for (int j=i+1; j<N; j++)
			if (dist[j] > dist[i] + cost[i][j])
				dist[j] = dist[i] + cost[i][j];
	
		return dist[N-1];
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
